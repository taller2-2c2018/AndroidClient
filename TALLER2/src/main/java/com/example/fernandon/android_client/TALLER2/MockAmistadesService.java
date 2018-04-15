package com.example.fernandon.android_client.TALLER2;

/**
 * Created by FernandoN on 14/04/2018.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.test.mock.MockContext;
import android.view.Display;

//import com.fiuba.gaff.comohoy.R;
//import com.fiuba.gaff.comohoy.model.Commerce;

import com.example.fernandon.android_client.TALLER2.Amistad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MockAmistadesService implements AmistadesService{

    //private static Context context;
    private List<Amistad> mAmistades;
    private Context mContext;

    public MockAmistadesService(Context context){
        mContext = context;
    }

    @Override
    public void updateAmistadesData() {

        mAmistades = new ArrayList<>();
        Amistad c1 = new Amistad("Fernando Nitz");
        //c1.setDescription("sisi, probando");


        Amistad c2 = new Amistad("Manuel Ortiz");
        //c2.setDescription("eee loco prueba");


        //c1.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.pizzaprueba2));
        //c2.setPicture(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.images));

        mAmistades.add(c1);
        mAmistades.add(c2);

    }

    @Override
    public List<Amistad> getAmistades() {
        if (mAmistades == null) {
            updateAmistadesData();
        }
        return mAmistades;
    }

    @Override
    public Amistad getAmistad(int index) {
        return mAmistades.get(index);
    }
}