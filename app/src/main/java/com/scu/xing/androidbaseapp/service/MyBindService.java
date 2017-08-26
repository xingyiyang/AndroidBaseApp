package com.scu.xing.androidbaseapp.service;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by xing on 2017/8/26.
 */

public class MyBindService extends Service{


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("info","MyBindService---onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.i("info","MyBindService---onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i("info","MyBindService---onDestroy");
        super.onDestroy();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i("info","MyBindService---unbindService");
        super.unbindService(conn);
    }

    public class MyBinder extends Binder{
        public MyBindService getService(){
            return MyBindService.this;
        }
    }

    public void play(){
        Log.i("info","播放");
    }

    public void zanting(){
        Log.i("info","暂停");
    }

    public void pre(){
        Log.i("info","上一首");
    }

    public void next(){
        Log.i("info","下一首");
    }
}
