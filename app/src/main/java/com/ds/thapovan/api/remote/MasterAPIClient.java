package com.ds.thapovan.api.remote;

import androidx.annotation.NonNull;

import com.bumptech.glide.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MasterAPIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(final String baseUrl) {
        if (retrofit == null) {

            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    HttpUrl.Builder builder = chain.request().url().newBuilder();
                    HttpUrl newUrl = builder
//                             .host(baseUrl)
                            .build();
                    Request.Builder requestBuilder = chain.request().newBuilder()
                            .url(newUrl)
                            .addHeader("Accept", "application/json");
                    /*if (TextUtil.isValidString(SessionManager.getInstance().getApiToken())){
                        requestBuilder.addHeader("Authorization", "Bearer " + SessionManager.getInstance().getApiToken());
                    }*/
                    final Request request = requestBuilder.build();
                    Response response = chain.proceed(request);
                    return response;
                }
            };

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(interceptor);

            if (BuildConfig.DEBUG) {
                APILogger logger = new APILogger();
                logger.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(logger);
            }

            OkHttpClient client = httpClient.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }
}