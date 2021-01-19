package com.ds.thapovan;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ds.thapovan.Commonutils.CommonUtils;
import com.ds.thapovan.Commonutils.DateSetter;
import com.google.gson.Gson;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentUserInfo extends Fragment {

    private AppPreferences preferences;

    @BindView(R.id.udob)
    TextView udob;
    @BindView(R.id.fromdate)
    TextView fromdate;
    @BindView(R.id.todate)
    TextView todate;

    @BindView(R.id.usubmit)
    Button usubmitbtn;

    @BindView(R.id.gendergroup)
    TextView ugender;

    @BindView(R.id.uname)
    TextView uname;
    @BindView(R.id.umail)
    TextView umail;
    @BindView(R.id.uAddress)
    TextView uaddress;
    @BindView(R.id.ucity)
    TextView ucity;
    @BindView(R.id.uzip)
    TextView uzip;
    @BindView(R.id.uwrk)
    TextView uoccupation;
    @BindView(R.id.uphone)
    TextView uphone;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_userinfo, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        preferences = new AppPreferences(getActivity());


    }

    @OnClick({R.id.fromdate, R.id.todate, R.id.udob, R.id.usubmit, R.id.gendergroup})
    public void OnClick(View view) {
        switch (view.getId()) {
            case R.id.udob:
                DateSetter.selectDate(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        udob.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, false, null);
                break;
            case R.id.fromdate:
                DateSetter.selectDate(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        fromdate.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, false, null);
                break;
            case R.id.todate:
                DateSetter.selectDate(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        todate.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, true, fromdate.getText().toString());
                break;
            case R.id.usubmit:
                addDataToPreference();
            case R.id.gendergroup:
                CommonUtils.openPopupDialog(getActivity(),ugender,R.menu.gender_menu);
            }
    }

    private void addDataToPreference() {
        Userdetails obj = new Userdetails();
        obj.Name = uname.getText().toString();
        obj.Email = umail.getText().toString();
        obj.Phone = uphone.getText().toString();
        obj.DOB = udob.getText().toString();
        obj.Address = uaddress.getText().toString();
        obj.City = ucity.getText().toString();
        obj.Zipcode = uzip.getText().toString();
        obj.Occupation = uoccupation.getText().toString();
        obj.FromDate = fromdate.getText().toString();
        obj.ToDate = todate.getText().toString();
        obj.Gender = ugender.getText().toString();


        Gson gson = new Gson();
        String json = gson.toJson(obj);
        preferences.putOb(json);
        afterAdding();

    }

    private void afterAdding() {
        Toast.makeText(getActivity(), R.string.success, Toast.LENGTH_SHORT).show();
        uname.setText("");
        uoccupation.setText("");
        uzip.setText("");
        ucity.setText("");
        uaddress.setText("");
        umail.setText("");
        uphone.setText("");
        udob.setText("");
        fromdate.setText("");
        todate.setText("");
        ugender.setText("");
    }

}
