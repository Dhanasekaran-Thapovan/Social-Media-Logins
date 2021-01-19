package com.ds.thapovan;

import android.net.DnsResolver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ds.thapovan.adduser_respose.AddUserRespose;
import com.ds.thapovan.api_respose.DataItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentAddUser extends Fragment {

    @BindView(R.id.add_name)
    EditText addName;
    @BindView(R.id.add_age)
    EditText addAge;
    @BindView(R.id.add_sal)
    EditText addSal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


    }

    @OnClick({R.id.add_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_btn:
                if (addName.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), R.string.valid_name, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (addAge.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), R.string.valid_age, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (addSal.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), R.string.valid_sal, Toast.LENGTH_SHORT).show();
                    return;
                }

                HashMap userMap = collectData();
                retrofitCall(userMap);
        }
    }

    private HashMap collectData() {
        HashMap map = new HashMap<String, String>();

        map.put(getString(R.string._name), addName.getText().toString());
        map.put(getString(R.string._age), addAge.getText().toString());
        map.put(getString(R.string._salary), addSal.getText().toString());
        return map;
    }

    private void retrofitCall(HashMap userMap) {
        Retrofit addUser = new Retrofit.Builder().baseUrl(APIConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Call call = addUser.create(RetrofitInterface.class).postUser(userMap);
        call.enqueue(new Callback<AddUserRespose>(){
            @Override
            public void onResponse(Call<AddUserRespose> call, Response<AddUserRespose> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals(getString(R.string.success))) {
                        Toast.makeText(getActivity(),response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        addName.setText("");addAge.setText("");addSal.setText("");

                    } else {
                        Toast.makeText(getActivity(), R.string.went_erong, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), R.string.went_erong, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddUserRespose> call, Throwable t) {
                Toast.makeText(getActivity(), R.string.check_connection, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
