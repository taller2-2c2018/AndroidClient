package com.example.fernandon.android_client.TALLER2.services;
import android.content.Context;

import com.example.fernandon.android_client.TALLER2.model.Historia;
import com.example.fernandon.android_client.TALLER2.services.HistoriasService;

import java.util.ArrayList;
import java.util.List;


public class MockHistoriasService implements HistoriasService {

    //private static Context context;
    private List<Historia> mHistorias;
    private Context mContext;
    public MockHistoriasService(Context context){
        mContext = context;
    }

    @Override
    public void updateHistoriasData() {

        mHistorias = new ArrayList<>();
        Historia c1 = new Historia("Fernando Nitz");
        Historia c2 = new Historia("Manuel Ortiz");
        //c1.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.pizzaprueba2));
        //c2.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
        mHistorias.add(c1);
        mHistorias.add(c2);
    }

    @Override
    public List<Historia> getHistorias() {
        if (mHistorias == null) {
            updateHistoriasData();
        }
        return mHistorias;
    }

    @Override
    public Historia getHistoria(int index) {
        return mHistorias.get(index);
    }
}