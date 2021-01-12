package com.ds.thapovan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GoogleSignInClient mGoogleSignInClient;
    private static final int SIGN_IN_CODE = 1001;
    private AppPreferences preferences;
    private LoginManager loginManager;
    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = new AppPreferences(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        loginManager = LoginManager.getInstance();
        callbackManager = CallbackManager.Factory.create();
        facebookSignIn();

        findViewById(R.id.signin_by_google).setOnClickListener(this);
        findViewById(R.id.signin_by_facebook).setOnClickListener(this);
        findViewById(R.id.loginbtn).setOnClickListener(this);


    }

    /*private void printHashKey(MainActivity context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), getPackageManager().GET_SIGNING_CERTIFICATES);
            for (Signature item : info.signingInfo.getSigningCertificateHistory()) {
                MessageDigest md = null;
                try {
                    md = MessageDigest.getInstance("SHA");
                    md.update(item.toByteArray());
                    String hashKey = new String(Base64.encode(md.digest(), 0));
                    Log.i("AppLog", hashKey);

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }


            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.signin_by_google:
                googleSignIn();
                break;
            case R.id.signin_by_facebook:
                loginManager.logInWithReadPermissions(this, Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));
                break;
            case R.id.loginbtn:
                userLogin();

        }
    }

    private void userLogin() {
        EditText userName=findViewById(R.id.userName);
        EditText userid=findViewById(R.id.userid);
        EditText pass=findViewById(R.id.password);
        if(!isValidEmail(userid.getText().toString()) || userName.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
            Toast.makeText(this,"Invalid Data",Toast.LENGTH_SHORT).show();
        }else {
            preferences.putUserMail(userid.getText().toString());
            preferences.putUserName(userName.getText().toString());
            Intent nextIntent = new Intent(MainActivity.this, SecondaryActivity.class);
            startActivity(nextIntent);
        }
    }

    private void facebookSignIn() {
        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("success", loginResult.toString());
                graphLoginRequest(loginResult.getAccessToken());


            }

            @Override
            public void onCancel() {
                Log.i("success", "cancel");

            }

            @Override
            public void onError(FacebookException error) {
                Log.i("success", error.getLocalizedMessage());
            }
        });
    }

    private void graphLoginRequest(AccessToken accessToken) {
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {

            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    preferences.putUserName(object.getString("name"));
                    preferences.putUserMail(object.getString("email"));
                    Intent nextIntent = new Intent(MainActivity.this, SecondaryActivity.class);
                    startActivity(nextIntent);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender,birthday");
        request.setParameters(parameters);
        request.executeAsync();

    }

    /*Google Sign In*/

    private void googleSignIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, SIGN_IN_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        }
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            if (account != null) {
                preferences.putUserName(account.getDisplayName());
                preferences.putUserMail(account.getEmail());
                preferences.putToken(account.getIdToken());
            }
            Intent nextIntent = new Intent(this, SecondaryActivity.class);
            startActivity(nextIntent);
        } catch (ApiException e) {
            e.printStackTrace();
            Log.i("Google sign", "Failed");

        }
    }
    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

}