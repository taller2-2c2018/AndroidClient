package com.example.fernandon.android_client.TALLER2.services.facebook;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

import com.example.fernandon.android_client.TALLER2.services.CustomService;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

public interface FacebookService extends CustomService {
    String getAuthToken();
    boolean isLoggedIn();
    void loginWithAccesToken (Activity activity, LoginCallback loginCalback);
    void initializeLoginButton(Activity activity, LoginCallback loginCallback);
    void initializeLoginButton(Fragment fragment, LoginCallback loginCallback);
    void onActivityResult(int requestCode, int resultCode, Intent data);
}
