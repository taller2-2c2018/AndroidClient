package com.example.fernandon.android_client.TALLER2.services;

import android.content.Context;
import com.example.fernandon.android_client.TALLER2.R;
import android.graphics.BitmapFactory;
import com.example.fernandon.android_client.TALLER2.model.Amistad;
import java.util.ArrayList;
import java.util.List;

public class MockAmistadesService implements AmistadesService {

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
        c1.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ringo));
        c2.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.markz));
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