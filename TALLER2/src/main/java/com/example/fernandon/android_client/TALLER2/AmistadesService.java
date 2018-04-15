package com.example.fernandon.android_client.TALLER2;
import com.example.fernandon.android_client.TALLER2.Amistad;

import java.util.List;

/**
 * Created by FernandoN on 14/04/2018.
 */

public interface AmistadesService extends CustomService{

    void updateAmistadesData();
    List<Amistad> getAmistades();
    Amistad getAmistad(int index);
}