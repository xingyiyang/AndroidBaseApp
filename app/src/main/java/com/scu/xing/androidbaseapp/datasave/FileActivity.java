package com.scu.xing.androidbaseapp.datasave;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.scu.xing.androidbaseapp.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xing on 2017/8/24.
 */

public class FileActivity extends AppCompatActivity implements View.OnClickListener{

    Button filenew;
    EditText editText;
    Button buttonwriteread;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file);

        iniwidget();
        initListener();
    }

    private void iniwidget(){
        filenew = (Button)findViewById(R.id.filenew);
        editText = (EditText)findViewById(R.id.fileeditwrite);
        buttonwriteread = (Button)findViewById(R.id.filewriteread);
        textView = (TextView)findViewById(R.id.filetextviewread);
    }

    private void initListener(){
        filenew.setOnClickListener(this);
        buttonwriteread.setOnClickListener(this);
    }

    /**
     * 创建文件
     */
    private void createfile(){
        File file = new File(this.getFilesDir()+"/test.txt");
        if(!file.exists()){
            try{
                file.createNewFile();
                Toast.makeText(FileActivity.this,"文件创建成功",Toast.LENGTH_SHORT).show();
            }catch(IOException e){
                e.printStackTrace();
            }
        }else{
            Toast.makeText(FileActivity.this,"文件已存在",Toast.LENGTH_SHORT).show();
        }
        File file1 = this.getFilesDir();
        Log.i("info",file1.toString());
        File file2 = this.getExternalCacheDir();
        Log.i("info",file2.toString());
    }

    /**
     * 写入数据到文件
     */
    private void writeFile(String string){
        try {
            FileOutputStream fos = openFileOutput("a.txt",MODE_PRIVATE);
            fos.write(string.getBytes());
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 读取文件数据
     */
    private String readFile(){

        String content = null;
        try{
            FileInputStream fis = openFileInput("a.txt");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer= new byte[1024];
            int len=0;
            while ((len=fis.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }
            content = baos.toString();
            fis.close();
            baos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.filenew:
                createfile();
                filenew.setEnabled(false);
                break;
            case R.id.filewriteread:
                writeFile(editText.getText().toString().trim());
                textView.setText(readFile());
                break;
            default:
                break;
        }
    }
}
