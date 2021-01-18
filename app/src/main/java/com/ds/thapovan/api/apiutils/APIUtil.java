package com.ds.thapovan.api.apiutils;


import android.util.Log;

import com.ds.thapovan.APIInterface;
import com.ds.thapovan.api.remote.MasterAPIClient;
import com.ds.thapovan.api.response.GenericResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.ResponseBody;


public class APIUtil {

    private APIUtil() {
    }

    private static Gson gson;

    private static final String LOG_TAG = APIUtil.class.getSimpleName();

    // MediaType
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpg");
    public static final MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");
    public static final MediaType MEDIA_TYPE_IMAGE = MediaType.parse("image/*");
    public static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    public static final LinkedHashMap<String, String> SERVER_URL;


    // The default url will be selected
    public static final int DEFAULT_URL_INDEX = 0;

    public static final List<String> PRODUCTION = new ArrayList<String>(Arrays.asList("prod", "uat", "staging")) {
    };

    // APIAbstract
    public static final String EMPLOYLEE_LIST_URL = "employees";

    static {
        SERVER_URL = new LinkedHashMap<>();
        SERVER_URL.put("dev", "https://jsonplaceholder.typicode.com/");
    }

    public static String getKeyAt(LinkedHashMap<String, String> map, int pos) {
        return (new ArrayList<>(map.keySet())).get(pos);
    }

    public static String getValueAt(LinkedHashMap<String, String> map, int pos) {
        return (new ArrayList<>(map.values())).get(pos);
    }

    // APIAbstract
    public static final String API_GET_IMAGE = "EMPLOYLEE_LIST_URL";



    public static APIInterface getMasterAPI() {
        return MasterAPIClient.getClient(SERVER_URL.get("dev")).create(APIInterface.class);
    }



    public static Gson getGSON() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .create();
        }
        return gson;
    }

//    public static <T extends GenericResponse> T getGenericResponseErr(Class<T> clazz, Throwable t) {
//        return getGenericResponseErrWithCode(clazz,t);
//    }

//    @SuppressWarnings("unchecked")
//    public static <T extends GenericResponse> T getGenericResponseErrWithCode(Class<T> clazz, Throwable t) {
////		L.log("####ERROR####", t.getMessage());
////		t.printStackTrace();
//
//        String code;
////        }
//    }

    public static <T extends GenericResponse> T getGenericResponseErr(Class<T> clazz) {
        //            T response = clazz.newInstance();
//            response.setSuccess("0");
//            response.setMessage(AppController.getStr(R.string.server_msg_unable_process));
//            return response;
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T extends GenericResponse> T processUnSuccessResponce(int responseCode, ResponseBody responseBody, Class<T> clazz) {
        if (responseCode == HttpURLConnection.HTTP_BAD_REQUEST) {
            final Gson gson = APIUtil.getGSON();
            T errResponse;
            try {
                errResponse = gson.fromJson(responseBody.string(), clazz);
                return errResponse;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    GenericResponse response = clazz.newInstance();
                    response.setSuccess("0");
                    response.setShowErrPopup("1");
                    response.setIsUserLoggedOut(false);
//					response.setErrorCode(AppController.getStr(R.string.android_err_code_JsonSyntaxException));
//                    response.setMessage(AppController.getStr(R.string.server_msg_unable_process));
                    return (T) response;
                } catch (Exception ex) {
                    return getGenericResponseErr(clazz);
                }
            }
        } else if (responseCode== HttpURLConnection.HTTP_UNAUTHORIZED){
            try {
                GenericResponse response=clazz.newInstance();
                response.setIsUserLoggedOut(true);
                return (T) response ;
            }catch (Exception e){
                return getGenericResponseErr(clazz);
            }
        }
//		else if (responseCode==HttpURLConnection.HTTP_UNAUTHORIZED){
//
//			return
//		}
        else {
            final Gson gson = APIUtil.getGSON();
            T errResponse;
            try {
                errResponse = gson.fromJson(responseBody.string(), clazz);
                return errResponse;
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    GenericResponse response = clazz.newInstance();
                    response.setSuccess("0");
                    response.setShowErrPopup("1");
                    response.setIsUserLoggedOut(false);
//				response.setErrorCode(AppController.getStr(R.string.android_err_code_http)+ responseCode);
                    response.setResponseCode(responseCode);
//                    response.setMessage(AppController.getStr(R.string.server_msg_unable_process));
                    return (T) response;
                } catch (Exception ex) {
                    return getGenericResponseErr(clazz);
                }
            }
        }
    }

    public static String getImgUrl(String awsUrl, boolean isThumb) {
        try {
            final StringBuilder builder = new StringBuilder();
//            builder.append(SessionManager.getInstance().getServerURL());
            builder.append(APIUtil.API_GET_IMAGE);
            builder.append("?fileName=");
            builder.append(awsUrl);
            Log.i("claim Image Pdf Url", builder.toString());
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}