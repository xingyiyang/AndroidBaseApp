package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/25.
 */

public class ShoushiActivity extends AppCompatActivity{

    ImageView imageshoushi;
    GestureDetector gestureDetector;
    class MyGesture extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if((e1.getX()-e2.getX())>50){
                Toast.makeText(ShoushiActivity.this,"从右往左",Toast.LENGTH_SHORT).show();
            }else if((e2.getX()-e1.getX())>50){
                Toast.makeText(ShoushiActivity.this,"从左往右",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(ShoushiActivity.this,"无法识别",Toast.LENGTH_SHORT).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoushi);

        gestureDetector = new GestureDetector(ShoushiActivity.this, new MyGesture());
        findViewById(R.id.imageshoushi).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                gestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });
    }

}
