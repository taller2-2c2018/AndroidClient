package com.example.fernandon.android_client.TALLER2.services;

import com.example.fernandon.android_client.TALLER2.model.Conversacion;
import java.util.List;

public interface ConversacionService extends CustomService {
    void updateConversacionData();
    List<Conversacion> getConversaciones();
    Conversacion getConversacion(int index);
}