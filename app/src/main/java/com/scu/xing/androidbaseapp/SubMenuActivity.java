package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/24.
 */

public class SubMenuActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        SubMenu file = menu.addSubMenu("文件");
        file.add(1,1,1,"新建");
        file.add(1,2,1,"打开");
        file.add(1,3,1,"保存");
        file.setHeaderTitle("文件操作");

        SubMenu edit = menu.addSubMenu("编辑");
        edit.add(2,1,1,"复制");
        edit.add(2,2,1,"粘贴");
        edit.add(2,3,1,"剪切");
        edit.setHeaderTitle("编辑操作");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //文件操作
        if(item.getGroupId() ==1){
            switch (item.getItemId()){
                case 1:
                    Toast.makeText(SubMenuActivity.this,"新建",Toast.LENGTH_SHORT);
                    break;
                case 2:
                    Toast.makeText(SubMenuActivity.this,"打开",Toast.LENGTH_SHORT);
                    break;
                case 3:
                    Toast.makeText(SubMenuActivity.this,"保存",Toast.LENGTH_SHORT);
                    break;
                default:
                    break;
            }
        }
        //编辑操作
        else if(item.getGroupId()==2){
            switch (item.getItemId()){
                case 1:
                    Toast.makeText(SubMenuActivity.this,"复制",Toast.LENGTH_SHORT);
                    break;
                case 2:
                    Toast.makeText(SubMenuActivity.this,"粘贴",Toast.LENGTH_SHORT);
                    break;
                case 3:
                    Toast.makeText(SubMenuActivity.this,"剪切",Toast.LENGTH_SHORT);
                    break;
                default:
                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
