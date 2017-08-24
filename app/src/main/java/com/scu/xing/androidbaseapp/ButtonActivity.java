package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by xing on 2017/8/24.
 */

public class ButtonActivity extends AppCompatActivity{

    Button button;
    ImageButton imageButton;
    ToggleButton toggleButton;
    CheckBox checkBox;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);

        initWidget();

        //监听Button按钮
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"button",Toast.LENGTH_SHORT).show();
            }
        });

        //监听ImageButton
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this,"imagebutton",Toast.LENGTH_SHORT).show();
            }
        });

        //监听toglebutton
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(ButtonActivity.this,"开",Toast.LENGTH_SHORT).show();
                    imageButton.setImageResource(R.mipmap.ic_launcher);
                }else{
                    Toast.makeText(ButtonActivity.this,"关",Toast.LENGTH_SHORT).show();
                    imageButton.setImageResource(R.mipmap.lufei);
                }
            }
        });

        //监听checkbox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(ButtonActivity.this,checkBox.getText().toString(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ButtonActivity.this,"checkbox close",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //监听radiogroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.radiobutton1:
                        Toast.makeText(ButtonActivity.this,"男",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobutton2:
                        Toast.makeText(ButtonActivity.this,"女",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radiobutton3:
                        Toast.makeText(ButtonActivity.this,"未知",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    /**
     * 初始化控件
     */
    public void initWidget(){

        button = (Button)findViewById(R.id.button);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        toggleButton = (ToggleButton)findViewById(R.id.togglebutton);
        checkBox = (CheckBox)findViewById(R.id.ckb_1);
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup);
    }
}
