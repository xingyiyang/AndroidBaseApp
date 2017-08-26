package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * activity的生命周期
 * Created by xing on 2017/8/24.
 */

public class ActivityLifeActivity extends AppCompatActivity{

    final String INFO = "info";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Log.i(INFO,"ActivityLifeActivity -> onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(INFO,"ActivityLifeActivity -> onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(INFO,"ActivityLifeActivity -> onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(INFO,"ActivityLifeActivity -> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(INFO,"ActivityLifeActivity -> onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(INFO,"ActivityLifeActivity -> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(INFO,"ActivityLifeActivity -> onDestroy");
    }
}
