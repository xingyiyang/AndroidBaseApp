package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by xing on 2017/8/24.
 */

public class ContextMenuActivity extends AppCompatActivity{

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contextmenu);

        listView = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,getData());
        listView.setAdapter(adapter);
        this.registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //设置menu显示的内容
        menu.setHeaderTitle("contextmenu");
        menu.setHeaderIcon(R.mipmap.lufei);
        menu.add(1,1,1,"复制");
        menu.add(1,2,1,"粘贴");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                Toast.makeText(ContextMenuActivity.this,"复制",Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(ContextMenuActivity.this,"粘贴",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);
    }

    private ArrayList<String> getData(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=1;i<4;i++){
            list.add("item"+i);
        }
        return list;
    }

}
