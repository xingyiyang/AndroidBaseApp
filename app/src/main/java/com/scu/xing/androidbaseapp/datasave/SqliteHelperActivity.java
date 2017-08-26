package com.scu.xing.androidbaseapp.datasave;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.scu.xing.androidbaseapp.R;

/**
 * Created by xing on 2017/8/25.
 */

public class SqliteHelperActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlitehelper);

        SqliteHelper helper = new SqliteHelper(SqliteHelperActivity.this,"stu.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor c = db.rawQuery("select * from stutb",null);
        if(c!=null){
            String[] clos = c.getColumnNames();
            while (c.moveToNext()){
                for(String columname:clos){
                    Log.i("info",columname+" : "+c.getString(c.getColumnIndex(columname)));
                }
            }
            c.close();
        }
        db.close();
    }
}
