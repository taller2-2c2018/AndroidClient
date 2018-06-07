package com.example.fernandon.android_client.TALLER2.networking;
public class NoConnectionException extends Exception {
    private static final String MESSAGE = "Internet connection not found";

    public NoConnectionException() {
        super(MESSAGE);
    }
}
