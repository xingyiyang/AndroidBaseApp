package com.scu.xing.androidbaseapp.broadcst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xing on 2017/8/25.
 */

public class BroadcastYouxu1 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        String message = intent.getStringExtra("msg");
        Log.i("info","3: "+message);

        //截断广播
        //abortBroadcast();
        Bundle bundle = new Bundle();
        bundle.putString("test","广播处理数据");
        setResultExtras(bundle);
    }
}
