package com.scu.xing.androidbaseapp.datasave;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.scu.xing.androidbaseapp.R;

/**
 * Created by xing on 2017/8/24.
 */

public class SharepreferenceActivity extends AppCompatActivity implements View.OnClickListener{

    Button sharewrite;
    Button shareread;
    TextView sharetextview;
    EditText edit_username;
    EditText edit_password;
    CheckBox checkBox;
    Button denglu;

    SharedPreferences pref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharepreference);

        //pref = PreferenceManager.getDefaultSharedPreferences(DataCunchuActivity.this);
        pref = getSharedPreferences("mypref",MODE_PRIVATE);
        initWidget();
        initListener();

        String username = pref.getString("username","");
        String password = pref.getString("password","");
        if(username == null){
            checkBox.setChecked(false);
        }else{
            checkBox.setChecked(true);
            edit_username.setText(username);
            if(password!=null){
                edit_password.setText(password);
            }
        }

    }

    private void initWidget(){
        sharewrite = (Button)findViewById(R.id.sharewrite);
        shareread = (Button)findViewById(R.id.shareread);
        sharetextview = (TextView)findViewById(R.id.sharetextview);
        edit_username = (EditText)findViewById(R.id.username);
        edit_password = (EditText)findViewById(R.id.password);
        checkBox = (CheckBox)findViewById(R.id.sharecheckbox);
        denglu = (Button)findViewById(R.id.sharedenglu);
    }

    private void initListener(){
        sharewrite.setOnClickListener(this);
        shareread.setOnClickListener(this);
        denglu.setOnClickListener(this);
    }

    /**
     * 使用sharepreference写入数据
     */
    private void shareprefWrite(){

        Editor editor = pref.edit();
        editor.putString("name","fty");
        editor.putInt("age",24);
        editor.putLong("time",System.currentTimeMillis());
        editor.putBoolean("default",true);
        editor.commit();
    }

    /**
     * 使用sharepreference读取数据
     */
    private void shareprefRead(){
        String name = pref.getString("name","null");
        int age = pref.getInt("age",0);
        sharetextview.setText(name+" : "+age);
    }

    private void login(){
        Editor editor = pref.edit();
        String username = edit_username.getText().toString().trim();
        String password = edit_password.getText().toString().trim();
        if("admin".equals(username) && "123456".equals(password)){
            if(checkBox.isChecked()){
                editor.putString("username",username);
                editor.putString("password",password);
                editor.commit();
            }else{
                editor.remove("username");
                editor.remove("password");
                editor.commit();
            }
            Toast.makeText(SharepreferenceActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(SharepreferenceActivity.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sharewrite:
                shareprefWrite();
                break;
            case R.id.shareread:
                shareprefRead();
                break;
            case R.id.sharedenglu:
                login();
                break;
            default:
                break;
        }
    }
}
