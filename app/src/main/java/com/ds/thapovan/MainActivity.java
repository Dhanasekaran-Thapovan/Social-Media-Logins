package com.ds.thapovan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private GoogleSignInClient mGoogleSignInClient;
    private static final int SIGN_IN_CODE = 1001;
    private AppPreferences preferences;
    private LoginManager loginManager;
    private CallbackManager callbackManager;
    @BindView(R.id.userName)
    EditText userName;
    @BindView(R.id.userid)
    EditText userid;
    @BindView(R.id.password)
    EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences = new AppPreferences(this);
        ButterKnife.bind(this);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        loginManager = LoginManager.getInstance();
        callbackManager = CallbackManager.Factory.create();
        facebookSignIn();

    }

    @OnClick({R.id.signin_by_google, R.id.signin_by_facebook, R.id.loginbtn})
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
        preferences.putLogin(true);
    }

    private void userLogin() {

        if (!isValidEmail(userid.getText().toString())) {
            Toast.makeText(this, "Enter a valid Mail", Toast.LENGTH_SHORT).show();
            if (userName.getText().toString().isEmpty()) {
                Toast.makeText(this, "Enter a valid username", Toast.LENGTH_SHORT).show();
                if (pass.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Enter a valid password", Toast.LENGTH_SHORT).show();
                }
            }
        } else {

            Userdetails obj = new Userdetails();
            obj.Name=userName.getText().toString();
            obj.Email=userid.getText().toString();
            Gson gson = new Gson();
            String json = gson.toJson(obj);
            preferences.putOb(json);
            Intent nextIntent = new Intent(MainActivity.this, DashboardActivity.class).putExtra(AppConstants.FRAGMENT_ID, AppConstants.FRAGMENT_HOME);
            startActivity(nextIntent);
        }
    }

    private void facebookSignIn() {
        loginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("success", loginResult.toString());
                Toast.makeText(MainActivity.this, R.string.success_msg, Toast.LENGTH_SHORT).show();
                graphLoginRequest(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                Log.i("success", "cancel");
                Toast.makeText(MainActivity.this, R.string.cancel_msg, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(FacebookException error) {
                Log.i("success", error.getLocalizedMessage());
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void graphLoginRequest(AccessToken accessToken) {
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {

            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {

                    Userdetails obj = new Userdetails();

                    obj.Name=object.getString("name");
                    obj.Email=object.getString("email");
                    obj.DOB=object.getString("birthday");
                    obj.img=object.getJSONObject("picture").getJSONObject("data").getString("url");

                    Gson gson = new Gson();
                    String json = gson.toJson(obj);
                    preferences.putOb(json);

                    Intent nextIntent = new Intent(MainActivity.this, DashboardActivity.class).putExtra(AppConstants.FRAGMENT_ID, AppConstants.FRAGMENT_HOME);
                    startActivity(nextIntent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email,gender,birthday,picture");
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
            Intent nextIntent = new Intent(this, DashboardActivity.class).putExtra(AppConstants.FRAGMENT_ID, AppConstants.FRAGMENT_HOME);
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