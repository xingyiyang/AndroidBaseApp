package com.scu.xing.androidbaseapp.datasave;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by xing on 2017/8/25.
 */

public class SqliteHelper extends SQLiteOpenHelper{

    public SqliteHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * 首次创建数据库时调用，一般写建库，建表的操作
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表
        db.execSQL("create table if not exists stutb(_id integer primary key autoincrement , name text not null, age integer not null, sex text not null)");
        db.execSQL("insert into stutb(name,age,sex) values('老六',20,'女')");
    }

    /**
     * 当数据库的表发生变化时，会自动执行
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
