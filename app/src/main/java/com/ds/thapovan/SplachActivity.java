package com.ds.thapovan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplachActivity extends AppCompatActivity {
    private AppPreferences preferences;
    private Intent nextIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        preferences = new AppPreferences(this);

        if (preferences.getLogin()){
            nextIntent = new Intent(this, DashboardActivity.class).putExtra(AppConstants.FRAGMENT_ID, AppConstants.FRAGMENT_HOME);
        }else {
            nextIntent = new Intent(this, MainActivity.class);
        }
        startActivity(nextIntent);

    }
}