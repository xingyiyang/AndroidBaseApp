package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by xing on 2017/8/24.
 */

public class ContextMenuzdyActivity extends AppCompatActivity{

    ListView listviewzdy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contextmenuzdy);

        listviewzdy = (ListView)findViewById(R.id.listviewzdy);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData());
        listviewzdy.setAdapter(adapter);
        this.registerForContextMenu(listviewzdy);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("文件操作");
        menu.setHeaderIcon(R.mipmap.lufei);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextmenu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.contextitem1:
                Toast.makeText(ContextMenuzdyActivity.this,"粘贴",Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextitem2:
                Toast.makeText(ContextMenuzdyActivity.this,"重命名",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    private ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=1;i<4;i++){
            list.add("文件"+i);
        }
        return list;
    }
}
