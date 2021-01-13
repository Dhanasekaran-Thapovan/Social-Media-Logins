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
        pDOB.setText(obj.DOB);
        Glide.with(getActivity())
                .load(obj.img)
                .into(pImg);

    }
}
