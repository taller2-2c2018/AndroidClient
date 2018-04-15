package com.example.fernandon.android_client.TALLER2.model;

public class Conversacion {

    private String mNombreConver = "";
    private String mDescription = "";

    public Conversacion(String nombreConver) {
        mNombreConver = nombreConver;
    }

    public String getNombreConver() {
        return mNombreConver;
    }

    public void setNombreConver(String nombreConver) {
        this.mNombreConver = nombreConver;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

}