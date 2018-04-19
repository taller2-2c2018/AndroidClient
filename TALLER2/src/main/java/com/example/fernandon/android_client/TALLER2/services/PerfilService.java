package com.example.fernandon.android_client.TALLER2.services;

import com.example.fernandon.android_client.TALLER2.model.Perfil;
import java.util.List;

public interface PerfilService extends CustomService{
    void updatePerfilData();
    List<Perfil> getPerfiles();
    Perfil getPerfil(int index);
}
