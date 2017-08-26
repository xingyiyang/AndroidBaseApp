package com.scu.xing.androidbaseapp;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/25.
 */

public class SystemServiceActivity extends AppCompatActivity implements View.OnClickListener{

    Button network;
    Button wifi;
    Button voice;
    Button packagename;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) SystemServiceActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.systemservice,null);
        setContentView(view);

        initWidget();
        initListener();
    }

    private void initWidget() {
        network = (Button)findViewById(R.id.network);
        wifi = (Button)findViewById(R.id.wifi);
        voice = (Button)findViewById(R.id.voice);
        packagename = (Button)findViewById(R.id.packagename);
    }

    private void initListener() {
        network.setOnClickListener(this);
        wifi.setOnClickListener(this);
        voice.setOnClickListener(this);
        packagename.setOnClickListener(this);
    }

    /**
     * 获取网络
     */
    private void getNetwork(Context context){

        if(context != null){
            ConnectivityManager cm =  (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if(networkInfo!=null){
                if(networkInfo.isAvailable()){
                    Toast.makeText(SystemServiceActivity.this,"网络已经打开",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SystemServiceActivity.this,"网络未连接",Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(SystemServiceActivity.this,"无法查看网络",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 获取wifi
     */
    private void getWifi(Context context){
        if(context != null){
            WifiManager wifiManager = (WifiManager) context.getSystemService(WIFI_SERVICE);
            if(wifiManager.isWifiEnabled()){
                wifiManager.setWifiEnabled(false);
                Toast.makeText(SystemServiceActivity.this,"wifi已关闭",Toast.LENGTH_SHORT).show();

            }else{
                wifiManager.setWifiEnabled(true);
                Toast.makeText(SystemServiceActivity.this,"wifi已打开",Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * 获取系统音量
     */
    private void getVoice(Context context){
        if(context != null){
            AudioManager audioManager = (AudioManager) context.getSystemService(AUDIO_SERVICE);
            int maxvolums = audioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
            int currentvolums = audioManager.getStreamVolume(AudioManager.STREAM_RING);
            Toast.makeText(SystemServiceActivity.this,"max: "+maxvolums+" current: "+currentvolums,Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获取程序包名
     */
    private void getPackagename(Context context){
        if(context != null){
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
            String paname = activityManager.getRunningTasks(1).get(0).topActivity.getPackageName();
            Toast.makeText(SystemServiceActivity.this,"当前程序包名"+paname,Toast.LENGTH_LONG).show();

        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.network:
                getNetwork(SystemServiceActivity.this);
                break;
            case R.id.wifi:
                getWifi(SystemServiceActivity.this);
                break;
            case R.id.voice:
                getVoice(SystemServiceActivity.this);
                break;
            case R.id.packagename:
                getPackagename(SystemServiceActivity.this);
                break;
            default:
                break;
        }
    }
}
