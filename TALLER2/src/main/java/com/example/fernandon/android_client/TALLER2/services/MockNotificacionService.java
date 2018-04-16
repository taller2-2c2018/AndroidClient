package com.example.fernandon.android_client.TALLER2.services;

import android.content.Context;

import com.example.fernandon.android_client.TALLER2.model.Historia;
import com.example.fernandon.android_client.TALLER2.model.Notificacion;

import java.util.ArrayList;
import java.util.List;


public class MockNotificacionService implements NotificacionesService {

    //private static Context context;
    private List<Notificacion> mNotificaciones;
    private Context mContext;

    public MockNotificacionService(Context context) {
        mContext = context;
    }

    @Override
    public void updateNotificacionesData() {

        mNotificaciones = new ArrayList<>();
        Notificacion c1 = new Notificacion("Emanuel");
        Notificacion c2 = new Notificacion("Alejandro");

        c1.setDescription("Emanuel te ha enviado una solicitud de amistad.");
        c2.setDescription("Alejandro ha comentado una foto en la que apareces.");

        //c1.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.pizzaprueba2));
        //c2.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));
        mNotificaciones.add(c1);
        mNotificaciones.add(c2);
    }

    @Override
    public List<Notificacion> getNotificaciones() {
        if (mNotificaciones == null) {
            updateNotificacionesData();
        }
        return mNotificaciones;
    }

    @Override
    public Notificacion getNotificacion(int index) {
        return mNotificaciones.get(index);
    }

}