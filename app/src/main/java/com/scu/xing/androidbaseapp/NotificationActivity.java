package com.scu.xing.androidbaseapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by xing on 2017/8/24.
 */

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener{

    Button send;
    Button cancel;
    NotificationManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        initWidget();
        initListener();
    }

    /**
     * 初始化控件
     */
    private void initWidget() {
        send = (Button)findViewById(R.id.notifysend);
        cancel = (Button)findViewById(R.id.notifycancel);
    }

    /**
     * 设置监听事件
     */
    private void initListener() {
        send.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    /**
     * 发送notification
     */
    private void sendnotification(){
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pintent = PendingIntent.getActivity(this,0,intent,0);
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.lufei);
        builder.setTicker("hello");
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle("标题");
        builder.setContentText("我是内容");
        builder.setContentIntent(pintent);
        builder.setAutoCancel(true);
        builder.setDefaults(Notification.DEFAULT_ALL);
        Notification notification = builder.build();
        manager.notify(1,notification);
    }

    /**
     * 取消notification
     */
    private void cancelnotification(){
        manager.cancel(1);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.notifysend:
                //发送
                sendnotification();
                break;
            case R.id.notifycancel:
                //取消
                cancelnotification();
                break;
            default:
                break;
        }
    }
}
