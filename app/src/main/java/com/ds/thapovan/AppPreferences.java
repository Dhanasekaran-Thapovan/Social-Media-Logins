package com.ds.thapovan;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {
    private SharedPreferences preferences;
    private String USER_NAME = "USER_NAME";
    private String USER_MAIL = "USER_MAIL";
    private String TOKEN = "TOKEN";
    private String OB = "OB";
    private String LOGIN = "LOGIN";


    public AppPreferences(Context context) {
        preferences = context.getSharedPreferences(
                BuildConfig.APPLICATION_ID,
                Context.MODE_PRIVATE
        );
    }

    void clearPreferences() {
        preferences.edit().clear();
    }

    void putUserName(String name) {
        preferences.edit().putString(USER_NAME, name).apply();
    }

    String getUserName() {
        return preferences.getString(USER_NAME, "");
    }

    void putUserMail(String mail) {
        preferences.edit().putString(USER_MAIL, mail).apply();
    }

    String getUserMail() {
        return preferences.getString(USER_MAIL, "");
    }

    void putToken(String token) {
        preferences.edit().putString(TOKEN, token).apply();
    }

    String getToken() {
        return preferences.getString(TOKEN, "");
    }

    void putOb(String obj){
        preferences.edit().putString(OB,obj).apply();
    }
    String getOb(){
        return preferences.getString(OB,"");
    }

    void putLogin(Boolean login) {
        preferences.edit().putBoolean(LOGIN, login).apply();
    }

    boolean getLogin() {
        return preferences.getBoolean(LOGIN, false);
    }

}
