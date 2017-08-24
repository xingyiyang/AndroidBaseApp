package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/**
 * Created by xing on 2017/8/23.
 */

public class TextViewActivity extends AppCompatActivity{

    TextView tv_1;
    TextView tv_2;
    AutoCompleteTextView actv_1;
    MultiAutoCompleteTextView mactv_1;
    private String[] strings = {"chengdu","shanghai","hainan","beijing1","beijing2"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);

        initWidget();

        //AutoCompleteTextView, MulAutoCopleteTextView, 输入2个字符自动匹配
        pipeitwocharacter();


    }

    /**
     * 初始化控件
     */
    public void initWidget(){

        tv_1 = (TextView)findViewById(R.id.tv_1);
        tv_2 = (TextView)findViewById(R.id.tv_2);
        actv_1 = (AutoCompleteTextView)findViewById(R.id.actv_1);
        mactv_1 = (MultiAutoCompleteTextView)findViewById(R.id.mactv_1);
    }

    /**
     * 匹配字符
     */
    public void pipeitwocharacter(){

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strings);
        actv_1.setAdapter(adapter);

        mactv_1.setAdapter(adapter);
        mactv_1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
