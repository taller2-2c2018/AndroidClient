package com.example.fernandon.android_client.TALLER2;

import android.app.Application;
import android.content.Context;

import com.example.fernandon.android_client.TALLER2.services.AmistadesService;
import com.example.fernandon.android_client.TALLER2.services.MockAmistadesService;
import com.example.fernandon.android_client.TALLER2.services.ServiceLocator;

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
        ServiceLocator.bindCustomServiceImplementation(AmistadesService.class, MockAmistadesService.class);
    }

}

