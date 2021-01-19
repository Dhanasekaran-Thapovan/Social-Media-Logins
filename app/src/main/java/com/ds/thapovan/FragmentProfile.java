package com.ds.thapovan;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentProfile extends Fragment {

    private AppPreferences preferences;
    @BindView(R.id.profile_name)
    TextView pName;
    @BindView(R.id.profile_mail)
    TextView pMail;
    @BindView(R.id.profile_dob)
    TextView pDOB;
    @BindView(R.id.profile_gender)
    TextView pGender;
    @BindView(R.id.profile_pic)
    CircleImageView pImg;

    @BindView(R.id.profile_phone)
    TextView pPhone;
    @BindView(R.id.profile_address)
    TextView pAddress;
    @BindView(R.id.profile_city)
    TextView pCity;
    @BindView(R.id.profile_zip)
    TextView pZip;
    @BindView(R.id.profile_occupation)
    TextView pOccupation;
    @BindView(R.id.profile_from)
    TextView pFrom;
    @BindView(R.id.profile_to)
    TextView pTo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferences = new AppPreferences(getActivity());
        ButterKnife.bind(this, view);

        Gson gson = new Gson();
        String json = preferences.getOb();
        Userdetails obj = gson.fromJson(json, Userdetails.class);
        pName.setText(obj.Name);
        pMail.setText(obj.Email);
        pPhone.setText(obj.Phone);
        pOccupation.setText(obj.Occupation);
        pDOB.setText(obj.DOB);
        pAddress.setText(obj.Address);
        pCity.setText(obj.City);
        pZip.setText(obj.Zipcode);
        pFrom.setText(obj.FromDate);
        pTo.setText(obj.ToDate);
        pGender.setText(obj.Gender);
        Glide.with(getActivity())
                .load(obj.img)
                .into(pImg);

    }
}
