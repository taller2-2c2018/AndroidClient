package com.example.fernandon.android_client.TALLER2.services;

import android.content.Context;

import com.example.fernandon.android_client.TALLER2.model.Conversacion;

import java.util.ArrayList;
import java.util.List;

public class MockConversacionService implements ConversacionService {

    //private static Context context;
    private List<Conversacion> mConversaciones;
    private Context mContext;

    public MockConversacionService(Context context){
        mContext = context;
    }

    @Override
    public void updateConversacionData() {

        mConversaciones = new ArrayList<>();
        Conversacion c1 = new Conversacion("Agustin Pollo");
        Conversacion c2 = new Conversacion("El Diego");

        c1.setDescription("ee loco tengo hambre amiwo");
        c2.setDescription("eeeeeeeeeeeeee...");

        mConversaciones.add(c1);
        mConversaciones.add(c2);
    }

    @Override
    public List<Conversacion> getConversaciones() {
        if (mConversaciones == null) {
            updateConversacionData();
        }
        return mConversaciones;
    }

    @Override
    public Conversacion getConversacion(int index) {
        return mConversaciones.get(index);
    }
}