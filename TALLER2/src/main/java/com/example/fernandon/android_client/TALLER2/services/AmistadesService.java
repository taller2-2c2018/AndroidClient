package com.example.fernandon.android_client.TALLER2.services;

import com.example.fernandon.android_client.TALLER2.model.Amistad;

import java.util.List;

public interface AmistadesService extends CustomService {

    void updateAmistadesData();
    List<Amistad> getAmistades();
    Amistad getAmistad(int index);
}