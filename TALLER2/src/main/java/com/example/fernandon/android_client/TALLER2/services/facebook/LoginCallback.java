package com.example.fernandon.android_client.TALLER2.services.facebook;

public interface LoginCallback {
    void onSuccess();
    void onCancel();
    void onError(String reason);
}
