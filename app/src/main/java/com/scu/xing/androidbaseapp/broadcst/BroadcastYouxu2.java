package com.scu.xing.androidbaseapp.broadcst;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by xing on 2017/8/25.
 */

public class BroadcastYouxu2 extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        String message = intent.getStringExtra("msg");
        Log.i("info","4: "+message);
        Bundle bundle = getResultExtras(true);
        String s2 = bundle.getString("test");
        Log.i("info","2收到处理后广播消息："+s2);
    }
}
