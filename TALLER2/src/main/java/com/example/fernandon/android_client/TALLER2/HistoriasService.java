package com.example.fernandon.android_client.TALLER2;
import java.util.List;

public interface HistoriasService extends CustomService{

    void updateHistoriasData();
    List<Historia> getHistorias();
    Historia getHistoria(int index);
}