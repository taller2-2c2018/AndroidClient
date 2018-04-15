package com.example.fernandon.android_client.TALLER2;

import java.util.List;

public interface AmistadesService extends CustomService{

    void updateAmistadesData();
    List<Amistad> getAmistades();
    Amistad getAmistad(int index);
}