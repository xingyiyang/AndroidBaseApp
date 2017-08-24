package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by xing on 2017/8/24.
 */

public class ToastActivity extends AppCompatActivity implements View.OnClickListener{

    Button toast1;
    Button toast2;
    Button toast3;
    Button toast4;
    Button toast5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toast);

        //初始化控件
        initWidget();

        //监听控件
        initListner();
    }

    /**
     * 初始化控件
     */
    public void initWidget(){
        toast1 = (Button)findViewById(R.id.toast1);
        toast2 = (Button)findViewById(R.id.toast2);
        toast3 = (Button)findViewById(R.id.toast3);
        toast4 = (Button)findViewById(R.id.toast4);
        toast5 = (Button)findViewById(R.id.toast5);
    }

    /**
     * 设置监听事件
     */
    public void initListner(){
        toast1.setOnClickListener(this);
        toast2.setOnClickListener(this);
        toast3.setOnClickListener(this);
        toast4.setOnClickListener(this);
        toast5.setOnClickListener(this);
    }

    /**
     * toast显示方式
     */
    private void toastShow(int i){
        Toast toast;
        switch (i){
            case 1:
                Toast.makeText(ToastActivity.this, "default", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(ToastActivity.this, "Long", Toast.LENGTH_LONG).show();
                break;
            case 3:
                toast = Toast.makeText(ToastActivity.this, "position change", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
                break;
            case 4:
                toast = Toast.makeText(ToastActivity.this, "image show", Toast.LENGTH_SHORT);
                LinearLayout linearLayout = (LinearLayout) toast.getView();
                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.mipmap.lufei);
                linearLayout.addView(imageView,0);
                toast.show();
                break;
            case 5:
                LayoutInflater inflater = LayoutInflater.from(this);
                View toast_view = inflater.inflate(R.layout.toastlayout,null);
                toast = new Toast(this);
                toast.setView(toast_view);
                toast.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toast1:
                //默认toast
                toastShow(1);
                break;
            case R.id.toast2:
                //长toast
                toastShow(2);
                break;
            case R.id.toast3:
                //改变位置toast
                toastShow(3);
                break;
            case R.id.toast4:
                //带有图片toast
                toastShow(4);
                break;
            case R.id.toast5:
                //自定义toast
                toastShow(5);
                break;
            default:
                break;
        }
    }
}
