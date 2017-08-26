package com.scu.xing.androidbaseapp.datasave;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.scu.xing.androidbaseapp.R;

/**
 * Created by xing on 2017/8/24.
 */

public class SqliteActivity extends AppCompatActivity implements View.OnClickListener{

    Button sqlitecreate;
    Button sqliteread;
    Button sqlitecreate2;
    ListView sqlitelistview;
    ListView sqlitelistview2;

    SQLiteDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);

        initwidget();
        initListener();
        //每个程序都有自己的数据库，默认情况下互不干扰
        //创建一个数据库，并且打开
        db = openOrCreateDatabase("user.db",MODE_PRIVATE,null);

    }

    private void initwidget(){
        sqlitecreate = (Button)findViewById(R.id.sqlitecreate);
        sqliteread = (Button)findViewById(R.id.sqliteread);
        sqlitelistview = (ListView)findViewById(R.id.sqlitelistview);
        sqlitecreate2 = (Button)findViewById(R.id.sqlitecreate2);
        sqlitelistview2 = (ListView)findViewById(R.id.sqlitelistview2);
    }

    private void initListener(){
        sqlitecreate.setOnClickListener(this);
        sqliteread.setOnClickListener(this);
        sqlitecreate2.setOnClickListener(this);
    }

    /**
     * 原生sql操作数据库
     */
    private void operatedatabase(){

        //删除表
        //db.execSQL("drop table usertb");
        db.execSQL("create table if not exists usertb(_id integer primary key autoincrement , name text not null, age integer not null, sex text not null)");
        //删除表中的所有数据
        db.execSQL("delete from usertb");
        //插入数据
        db.execSQL("insert into usertb(name,age,sex) values('aaa',25,'男')");
        db.execSQL("insert into usertb(name,age,sex) values('bbb',26,'女')");
        db.execSQL("insert into usertb(name,age,sex) values('ccc',27,'男')");
    }

    /**
     * 使用封装的方法操作sqlite
     */
    private void operatedatabase2(){

        //创建表
        db.execSQL("create table if not exists stutb(_id integer primary key autoincrement , name text not null, age integer not null, sex text not null)");

        //删除表中的所有数据
        db.execSQL("delete from stutb");
        db.execSQL("update sqlite_sequence SET seq = 0 where name ='stutb'");

        //插入数据，使用contentvalue
        ContentValues values = new ContentValues();

        values.put("name","张三");
        values.put("age",15);
        values.put("sex","男");
        db.insert("stutb",null,values);

        values.clear();
        values.put("name","李四");
        values.put("age",11);
        values.put("sex","女");
        db.insert("stutb",null,values);

        values.clear();
        values.put("name","王五");
        values.put("age",16);
        values.put("sex","女");
        db.insert("stutb",null,values);

        values.clear();
        values.put("name","张三丰");
        values.put("age",18);
        values.put("sex","女");
        db.insert("stutb",null,values);

        //改数据
        values.clear();
        values.put("sex","男");
        db.update("stutb",values,"age>?",new String[]{"15"});  //将age大于15的人性别改成男

        //删除数据
        db.delete("stutb","name like ?",new String[]{"%丰%"}); //删除所有名字中带丰字的人

        String[] strings = new String[3];
        int i=0;

        Cursor c = db.query("stutb",null,"_id>?",new String[]{"0"},null,null,"age");
        if(c!=null){
            String[] columnNames = c.getColumnNames();
            while (c.moveToNext()){
                StringBuilder stringBuilder = new StringBuilder();
                for(String columnname:columnNames){
                    Log.i("info",c.getString(c.getColumnIndex(columnname)));
                    stringBuilder.append(c.getString(c.getColumnIndex(columnname)).toString()+" : ");
                }
                strings[i] = stringBuilder.toString();
                i++;
            }
            c.close();
        }
        db.close();
        showData2(strings);

    }

    /**
     * 读取数据库
     */
    private void readedatabase(){
        String[] strings = new String[3];
        int i=0;
        Cursor cursor = db.rawQuery("select * from usertb",null);
        if(cursor!=null){
            while (cursor.moveToNext()){
//                Log.i("info","_id: "+cursor.getInt(cursor.getColumnIndex("_id")));
//                Log.i("info","name: "+cursor.getString(cursor.getColumnIndex("name")));
//                Log.i("info","age: "+cursor.getInt(cursor.getColumnIndex("age")));
//                Log.i("info","sex: "+cursor.getString(cursor.getColumnIndex("sex")));
                strings[i] = cursor.getInt(cursor.getColumnIndex("_id"))+" : "+
                        cursor.getString(cursor.getColumnIndex("name"))+" : "+
                                cursor.getInt(cursor.getColumnIndex("age"))+" : "+
                                        cursor.getString(cursor.getColumnIndex("sex"));
                i++;
            }
            cursor.close();
        }
        db.close();
        showData(strings);
    }

    /**
     * 在listview展示数据
     */
    private void showData(String[] strings){

        if(strings!=null){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
            sqlitelistview.setAdapter(adapter);
        }
    }

    /**
     * 在listview2展示数据
     */
    private void showData2(String[] strings){

        if(strings!=null){
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strings);
            sqlitelistview2.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sqlitecreate:
                operatedatabase();
                sqlitecreate.setVisibility(View.GONE);
                sqliteread.setVisibility(View.VISIBLE);
                break;
            case R.id.sqliteread:
                readedatabase();
                sqliteread.setEnabled(false);
                sqlitecreate2.setEnabled(false);
                break;
            case R.id.sqlitecreate2:
                operatedatabase2();
                sqlitecreate.setEnabled(false);
                sqlitecreate2.setEnabled(false);
                break;

            default:
                break;
        }
    }
}
