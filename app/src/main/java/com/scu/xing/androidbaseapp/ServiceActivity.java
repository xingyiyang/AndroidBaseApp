package com.scu.xing.androidbaseapp;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.scu.xing.androidbaseapp.service.MyBindService;
import com.scu.xing.androidbaseapp.service.MyStartService;

/**
 * Created by xing on 2017/8/25.
 */

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener{

    Button startbegin;
    Button startfinish;
    Button bindbegin;
    Button bindfinish;
    Button bofang;
    Button shangyishou;
    Button xiayishou;
    Button zanting;

    Intent intentstart;
    Intent intentbind;
    MyBindService myBindService;
    ServiceConnection connection = new ServiceConnection() {

        //当启动源跟service成功连接之后自动调用该方法
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBindService = ((MyBindService.MyBinder)iBinder).getService();
        }

        //当启动源跟service意外丢失时调用该方法
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serviceview);

        initWidget();
        initListener();
    }

    private void initWidget() {
        startbegin = (Button)findViewById(R.id.startbegin);
        startfinish = (Button)findViewById(R.id.startfinish);
        bindbegin = (Button)findViewById(R.id.bindbegin);
        bindfinish = (Button)findViewById(R.id.bindfinish);
        bofang = (Button)findViewById(R.id.bofang);
        shangyishou = (Button)findViewById(R.id.shangyishou);
        xiayishou = (Button)findViewById(R.id.xiayishou);
        zanting = (Button)findViewById(R.id.zanting);

    }

    private void initListener() {
        startbegin.setOnClickListener(this);
        startfinish.setOnClickListener(this);
        bindbegin.setOnClickListener(this);
        bindfinish.setOnClickListener(this);
        bofang.setOnClickListener(this);
        shangyishou.setOnClickListener(this);
        xiayishou.setOnClickListener(this);
        zanting.setOnClickListener(this);
    }

    /**
     * start方式开始
     */
    private void startBegin(){

        startbegin.setEnabled(false);
        startfinish.setEnabled(true);
        Toast.makeText(ServiceActivity.this,"startservice",Toast.LENGTH_SHORT).show();
        intentstart = new Intent(ServiceActivity.this, MyStartService.class);
        startService(intentstart);

    }

    /**
     * start方式结束
     */
    private void startFinish(){

        startfinish.setEnabled(false);
        startbegin.setEnabled(true);
        Toast.makeText(ServiceActivity.this,"finishservice",Toast.LENGTH_SHORT).show();
        stopService(intentstart);
    }

    /**
     * bind方式开始
     */
    private void bindBegin(){

        bindbegin.setEnabled(false);
        bindfinish.setEnabled(true);
        Toast.makeText(ServiceActivity.this,"bindservice",Toast.LENGTH_SHORT).show();
        intentbind = new Intent(ServiceActivity.this, MyBindService.class);
        bindService(intentbind,connection, Service.BIND_AUTO_CREATE);
    }

    /**
     * bind方式结束
     */
    private void bindFinish(){

        bindfinish.setEnabled(false);
        bindbegin.setEnabled(true);
        Toast.makeText(ServiceActivity.this,"unbindservice",Toast.LENGTH_SHORT).show();
        unbindService(connection);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startbegin:
                startBegin();
                break;
            case R.id.startfinish:
                startFinish();
                break;
            case R.id.bindbegin:
                bindBegin();
                break;
            case R.id.bindfinish:
                bindFinish();
                break;
            case R.id.bofang:
                myBindService.play();
                break;
            case R.id.shangyishou:
                myBindService.pre();
                break;
            case R.id.xiayishou:
                myBindService.next();
                break;
            case R.id.zanting:
                myBindService.zanting();
                break;
            default:
                break;
        }

    }

}
