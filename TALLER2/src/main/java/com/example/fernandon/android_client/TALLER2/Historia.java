package com.example.fernandon.android_client.TALLER2;

import android.graphics.Bitmap;
public class Historia {

    private String mTitulo = "";
    private String mDescription = "";
    private String mFecha = "";
    private String mUbicacion = "";
    private Bitmap mPicture;


    public Historia(String titulo) {
        mTitulo = titulo;
    }

    public String getmTitulo() {
        return mTitulo;
    }

    public void setTitulo(String titulo) {
        this.mTitulo = titulo;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getFecha() {
        return mFecha;
    }

    public void setFecha(String fecha) {
        this.mFecha = fecha;
    }

    public String getUbicacion() {
        return mUbicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.mUbicacion = ubicacion;
    }

    public Bitmap getPicture() {
        return mPicture;
    }

    public void setPicture(Bitmap picture) {
        this.mPicture = picture;
    }
}