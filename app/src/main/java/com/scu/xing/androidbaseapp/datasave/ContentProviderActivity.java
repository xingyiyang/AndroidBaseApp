package com.scu.xing.androidbaseapp.datasave;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.scu.xing.androidbaseapp.R;

/**
 * Created by xing on 2017/8/24.
 */

public class ContentProviderActivity extends AppCompatActivity implements View.OnClickListener{

    Button read;
    Button write;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contprovider);

        initWidget();
        initListener();
    }

    private void initWidget() {
        read = (Button)findViewById(R.id.contentproread);
        write = (Button)findViewById(R.id.contentprowrite);
    }

    private void initListener() {
        read.setOnClickListener(this);
        write.setOnClickListener(this);
    }

    /**
     * 读取联系人
     */
    private void contactsRead(){

        String cid = Contacts._ID;
        String cname = Contacts.DISPLAY_NAME;
        String[] array = {cid,cname};
        String[] arraynum = {Phone.NUMBER, Phone.TYPE};
        String[] arrayemail = {Email.DATA, Email.TYPE};

        ContentResolver resolver = getContentResolver();
        Cursor c = resolver.query(Contacts.CONTENT_URI,array,null,null,null);
        if(c!=null){
            while (c.moveToNext()){
                int id = c.getInt(c.getColumnIndex(cid));
                Log.i("info","id"+id);
                Log.i("info","name: "+c.getString(c.getColumnIndex(cname)));
                Cursor c1 = resolver.query(Phone.CONTENT_URI,arraynum, Phone.CONTACT_ID+"="+id,null,null);
                //根据id查询号码
                if(c1!=null){
                    while (c1.moveToNext()){
                        int type = c1.getInt(c1.getColumnIndex(Phone.TYPE));
                        if(type == Phone.TYPE_HOME){
                            Log.i("info","home number: "+c1.getString(c1.getColumnIndex(Phone.NUMBER)));

                        }else if(type == Phone.TYPE_MOBILE){
                            Log.i("info","mobile number: "+c1.getString(c1.getColumnIndex(Phone.NUMBER)));
                        }
                    }
                    c1.close();
                }
                //根据id查询邮箱
                Cursor c2 = resolver.query(Email.CONTENT_URI,arrayemail, Email.CONTACT_ID+"="+id,null,null);
                if(c2 != null){
                    while (c2.moveToNext()){
                        int type = c2.getInt(c2.getColumnIndex(Email.TYPE));
                        if(type == Email.TYPE_WORK){
                            Log.i("info","email work: "+c2.getString(c2.getColumnIndex(Email.DATA)));
                        }
                    }
                    c2.close();
                }
            }
            c.close();
        }
    }

    /**
     * 插入联系人
     */
    private void contactsWrite(){
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        Uri uri = cr.insert(RawContacts.CONTENT_URI,values);
        Long raw_contact_id = ContentUris.parseId(uri);

        //插入人名
        values.clear();
        values.put(StructuredName.RAW_CONTACT_ID,raw_contact_id);
        values.put(StructuredName.DISPLAY_NAME,"张三三");
        values.put(StructuredName.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
        cr.insert(Data.CONTENT_URI,values);

        //插入电话号码
        values.clear();
        values.put(Phone.RAW_CONTACT_ID,raw_contact_id);
        values.put(Phone.NUMBER,"13333333333");
        values.put(Phone.MIMETYPE,Phone.CONTENT_ITEM_TYPE);
        cr.insert(Data.CONTENT_URI,values);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.contentproread:
                contactsRead();
                break;
            case R.id.contentprowrite:
                contactsWrite();
            default:
                break;
        }
    }
}
