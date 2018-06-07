package com.example.fernandon.android_client.TALLER2;

import android.app.Application;
import android.content.Context;

import com.example.fernandon.android_client.TALLER2.services.AmistadesService;
import com.example.fernandon.android_client.TALLER2.services.ConversacionService;
import com.example.fernandon.android_client.TALLER2.services.HistoriasService;
import com.example.fernandon.android_client.TALLER2.services.MockAmistadesService;
import com.example.fernandon.android_client.TALLER2.services.MockConversacionService;
import com.example.fernandon.android_client.TALLER2.services.MockHistoriasService;
import com.example.fernandon.android_client.TALLER2.services.MockNotificacionService;
import com.example.fernandon.android_client.TALLER2.services.NotificacionesService;
import com.example.fernandon.android_client.TALLER2.services.ServiceLocator;
import com.example.fernandon.android_client.TALLER2.services.facebook.BaseFacebookService;
import com.example.fernandon.android_client.TALLER2.services.facebook.FacebookService;

public class AppMain extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // this method fires once as well as constructor
        // but also application has context here
        bindServices(getApplicationContext());
    }

    private void bindServices(Context applicationContext) {
        ServiceLocator.init(applicationContext);
        //ServiceLocator.bindCustomServiceImplementation(FacebookService.class, BaseFacebookService.class);
        ServiceLocator.bindCustomServiceImplementation(AmistadesService.class, MockAmistadesService.class);
        ServiceLocator.bindCustomServiceImplementation(HistoriasService.class, MockHistoriasService.class);
        ServiceLocator.bindCustomServiceImplementation(ConversacionService.class, MockConversacionService.class);
        ServiceLocator.bindCustomServiceImplementation(NotificacionesService.class, MockNotificacionService.class);
    }

}

