package com.ds.thapovan;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ds.thapovan.dateutils.DateSetter;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentDate extends Fragment {

    @BindView(R.id.fromdate)
    TextView fromdate;
    @BindView(R.id.todate)
    TextView todate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @OnClick({R.id.fromdate, R.id.todate})
    public void OnClick(View view) {
        switch (view.getId()) {
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
        }
    }

}
