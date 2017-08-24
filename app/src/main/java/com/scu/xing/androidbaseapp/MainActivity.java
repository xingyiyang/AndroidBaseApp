package com.scu.xing.androidbaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Intent intent;
    Button btn_textview;
    Button btn_edittext;
    Button btn_imageview;
    Button btn_button;
    Button btn_activity;
    Button btn_toast;
    Button btn_dialog;
    Button btn_notification;
    Button btn_contextmenu;
    Button btn_contextmenuzdy;
    Button btn_submenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initWidget();

        //监听控件
        initListner();

    }

    /**
     * 初始化界面的控件
     */
    public void initWidget(){

        btn_textview = (Button)findViewById(R.id.btn_textview);
        btn_edittext = (Button)findViewById(R.id.btn_edittext);
        btn_imageview = (Button)findViewById(R.id.btn_imageview);
        btn_button = (Button)findViewById(R.id.btn_button);
        btn_activity = (Button)findViewById(R.id.btn_activity);
        btn_toast = (Button)findViewById(R.id.btn_toast);
        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        btn_notification = (Button)findViewById(R.id.btn_notification);
        btn_contextmenu = (Button)findViewById(R.id.btn_contextmenu);
        btn_contextmenuzdy = (Button)findViewById(R.id.btn_contextmenuzdy);
        btn_submenu = (Button)findViewById(R.id.btn_submenu);
    }

    /**
     * 调用onclickListner的接口监听button
     */
    public void initListner(){

        btn_textview.setOnClickListener(this);
        btn_edittext.setOnClickListener(this);
        btn_imageview.setOnClickListener(this);
        btn_button.setOnClickListener(this);
        btn_activity.setOnClickListener(this);
        btn_toast.setOnClickListener(this);
        btn_dialog.setOnClickListener(this);
        btn_notification.setOnClickListener(this);
        btn_contextmenu.setOnClickListener(this);
        btn_contextmenuzdy.setOnClickListener(this);
        btn_submenu.setOnClickListener(this);
    }

    /**
     * 监听事件处理，跳转到其他窗口
     * @param view
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_textview:
                intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_edittext:
                intent = new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_imageview:
                intent = new Intent(MainActivity.this, ImageViewActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_button:
                intent = new Intent(MainActivity.this, ButtonActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_activity:
                intent = new Intent(MainActivity.this, ActivityLifeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_toast:
                intent = new Intent(MainActivity.this, ToastActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_dialog:
                intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_notification:
                intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_contextmenu:
                intent = new Intent(MainActivity.this, ContextMenuActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_contextmenuzdy:
                intent = new Intent(MainActivity.this, ContextMenuzdyActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_submenu:
                intent = new Intent(MainActivity.this, SubMenuActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
