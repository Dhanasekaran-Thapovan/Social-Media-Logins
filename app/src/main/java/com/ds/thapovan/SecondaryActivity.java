package com.ds.thapovan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class SecondaryActivity extends AppCompatActivity implements View.OnClickListener {

    private AppPreferences preferences;
    private GoogleSignInClient mGoogleSignInClient;

    TextView username;
    TextView usermail;
    Button signout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        preferences = new AppPreferences(this);

        username = findViewById(R.id.username);
        usermail = findViewById(R.id.usermail);
        signout = findViewById(R.id.signout);

        username.setText(preferences.getUserName());
        usermail.setText(preferences.getUserMail());

        signout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signout:
                googleSignOut();
        }
    }

    private void googleSignOut() {
        mGoogleSignInClient.signOut().addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

            }
        });
    }
}