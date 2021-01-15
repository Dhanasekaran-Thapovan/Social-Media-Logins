package com.ds.thapovan;

import android.net.DnsResolver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ds.thapovan.api_respose.DataItem;
import com.ds.thapovan.api_respose.GetEmployeeListResponse;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentHome extends Fragment {

    private AppPreferences preferences;
    @BindView(R.id.home_rec_view)
    RecyclerView emp_rec;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = new AppPreferences(getActivity());
        ButterKnife.bind(this, view);

        retrofitCall();
    }

    private void retrofitCall() {
        Retrofit empRetrofit = new Retrofit.Builder().baseUrl(APIConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Call call = empRetrofit.create(RetrofitInterface.class).getEmployees();
        call.enqueue(new Callback<GetEmployeeListResponse>() {
            @Override
            public void onResponse(Call<GetEmployeeListResponse> call, Response<GetEmployeeListResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("success")) {
                        List<DataItem> parser = response.body().getData();
                        emp_rec.setLayoutManager(new LinearLayoutManager(getActivity(),
                                LinearLayoutManager.VERTICAL,
                                false));
                        EmpRecAdapter adapter = new EmpRecAdapter(parser);

                        emp_rec.setAdapter(adapter);

                    } else {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetEmployeeListResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Check Your Connection", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
