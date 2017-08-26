package com.scu.xing.androidbaseapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.scu.xing.androidbaseapp.datasave.ContentProviderActivity;
import com.scu.xing.androidbaseapp.datasave.FileActivity;
import com.scu.xing.androidbaseapp.datasave.SharepreferenceActivity;
import com.scu.xing.androidbaseapp.datasave.SqliteActivity;
import com.scu.xing.androidbaseapp.datasave.SqliteHelper;
import com.scu.xing.androidbaseapp.datasave.SqliteHelperActivity;

/**
 * Created by xing on 2017/8/24.
 */

public class DataCunchuActivity extends AppCompatActivity implements View.OnClickListener{

    Button datashare;
    Button datasqlite;
    Button datasqlitehlper;
    Button datacontentp;
    Button datafile;
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datacunchu);

        initWidget();
        initListener();

    }

    private void initWidget() {
        datashare = (Button)findViewById(R.id.datashare);
        datacontentp = (Button)findViewById(R.id.datacontentp);
        datasqlite = (Button)findViewById(R.id.datasqlite);
        datasqlitehlper = (Button)findViewById(R.id.datasqlitehelper);
        datafile = (Button)findViewById(R.id.datafile);
    }

    private void initListener() {
        datashare.setOnClickListener(this);
        datasqlite.setOnClickListener(this);
        datacontentp.setOnClickListener(this);
        datafile.setOnClickListener(this);
        datasqlitehlper.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.datashare:
                intent = new Intent(DataCunchuActivity.this, SharepreferenceActivity.class);
                startActivity(intent);
                break;
            case R.id.datasqlite:
                intent = new Intent(DataCunchuActivity.this, SqliteActivity.class);
                startActivity(intent);
                break;
            case R.id.datasqlitehelper:
                intent = new Intent(DataCunchuActivity.this, SqliteHelperActivity.class);
                startActivity(intent);
                break;
            case R.id.datacontentp:
                intent = new Intent(DataCunchuActivity.this, ContentProviderActivity.class);
                startActivity(intent);
                break;
            case R.id.datafile:
                intent = new Intent(DataCunchuActivity.this, FileActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
