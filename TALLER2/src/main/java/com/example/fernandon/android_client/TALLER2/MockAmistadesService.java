package com.example.fernandon.android_client.TALLER2;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class MockAmistadesService implements AmistadesService{

    //private static Context context;
    private List<Amistad> mAmistades;
    private Context mContext;
    public MockAmistadesService(Context context){
        mContext = context;
    }

    @Override
    public void updateAmistadesData() {

        mAmistades = new ArrayList<>();
        Amistad c1 = new Amistad("Fernando Nitz");
        Amistad c2 = new Amistad("Manuel Ortiz");
        //c1.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.pizzaprueba2));
        //c2.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
        mAmistades.add(c1);
        mAmistades.add(c2);
    }

    @Override
    public List<Amistad> getAmistades() {
        if (mAmistades == null) {
            updateAmistadesData();
        }
        return mAmistades;
    }

    @Override
    public Amistad getAmistad(int index) {
        return mAmistades.get(index);
    }
}