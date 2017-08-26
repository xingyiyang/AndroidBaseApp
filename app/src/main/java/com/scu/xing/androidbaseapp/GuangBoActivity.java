package com.scu.xing.androidbaseapp;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.scu.xing.androidbaseapp.broadcst.BroadcastAjax1;
import com.scu.xing.androidbaseapp.broadcst.BroadcastPutong2;

/**
 * Created by xing on 2017/8/25.
 */

public class GuangBoActivity extends AppCompatActivity implements View.OnClickListener{

    Button guangboputong;
    Button guangboyouxu;
    Button guangboyibu;

    BroadcastPutong2 bc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guangbo);

        //动态注册广播
        IntentFilter intentFilter = new IntentFilter("BC_One");
        bc = new BroadcastPutong2();
        registerReceiver(bc,intentFilter);

        initWidget();
        initListener();
    }

    private void initWidget() {
        guangboputong = (Button)findViewById(R.id.guangboputong);
        guangboyouxu = (Button)findViewById(R.id.guangboyouxu);
        guangboyibu = (Button)findViewById(R.id.guangboyibu);
    }

    private void initListener() {
        guangboputong.setOnClickListener(this);
        guangboyouxu.setOnClickListener(this);
        guangboyibu.setOnClickListener(this);
    }

    /**
     * 发送普通广播
     */
    private void sendNormal(){

        Intent intent = new Intent();
        intent.putExtra("msg","这是一条普通广播");
        intent.setAction("BC_One");
        sendBroadcast(intent);
    }

    /**
     * 发送有序广播
     */
    private void sendOrder(){

        Intent intent = new Intent();
        intent.putExtra("msg","这是一条有序广播");
        intent.setAction("BC_Two");
        sendOrderedBroadcast(intent,null);
    }

    /**
     * 发送异步广播
     */
    private void sendAjax(){

        Intent intent = new Intent();
        intent.putExtra("msg","这是一条异步广播");
        intent.setAction("BC_Three");
        sendStickyBroadcast(intent);

        //动态注册
        IntentFilter intentFilter3 = new IntentFilter("BC_Three");
        BroadcastAjax1 bcajax = new BroadcastAjax1();
        registerReceiver(bcajax,intentFilter3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.guangboputong:
                sendNormal();
                Toast.makeText(GuangBoActivity.this,"发送一条普通广播",Toast.LENGTH_SHORT).show();
                break;
            case R.id.guangboyouxu:
                sendOrder();
                Toast.makeText(GuangBoActivity.this,"发送一条有序广播",Toast.LENGTH_SHORT).show();
                break;
            case R.id.guangboyibu:
                sendAjax();
                Toast.makeText(GuangBoActivity.this,"发送一条异步广播",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bc);
    }
}
