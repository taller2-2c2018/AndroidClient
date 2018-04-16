package com.example.fernandon.android_client.TALLER2.services;

import com.example.fernandon.android_client.TALLER2.model.Notificacion;
import java.util.List;

public interface NotificacionesService extends CustomService {
    void updateNotificacionesData();
    List<Notificacion> getNotificaciones();
    Notificacion getNotificacion(int index);
}