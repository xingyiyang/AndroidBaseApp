package com.scu.xing.androidbaseapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by xing on 2017/8/26.
 */

public class MyStartService extends Service{


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","MystartService----onBind");
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("info","MystartService----onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("info","MystartService----onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.i("info","MystartService----onDestroy");
        super.onDestroy();
    }
}
