package com.scu.xing.androidbaseapp.broadcst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by xing on 2017/8/25.
 */

public class BroadcastPutong1 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        String message = intent.getStringExtra("msg");
        Log.i("info","1: "+message);
    }
}
