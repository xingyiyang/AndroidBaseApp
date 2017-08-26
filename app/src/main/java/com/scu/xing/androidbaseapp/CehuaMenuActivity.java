package com.scu.xing.androidbaseapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.scu.xing.androidbaseapp.slidemenu.SlidingMenu;

/**
 * Created by xing on 2017/8/26.
 */

public class CehuaMenuActivity extends Activity{

    private SlidingMenu slidingMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏显示屏上方的title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cehuamenu);

        slidingMenu = (SlidingMenu)findViewById(R.id.slidemenu);
    }

    public void toggleMenu(View v){
        slidingMenu.toggle();
    }
}
