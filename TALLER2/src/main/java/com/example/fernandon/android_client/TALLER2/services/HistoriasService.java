package com.example.fernandon.android_client.TALLER2.services;
import com.example.fernandon.android_client.TALLER2.model.Historia;

import java.util.List;

public interface HistoriasService extends CustomService {

    void updateHistoriasData();
    List<Historia> getHistorias();
    Historia getHistoria(int index);
}