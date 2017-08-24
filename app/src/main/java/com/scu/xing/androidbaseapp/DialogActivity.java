package com.scu.xing.androidbaseapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by xing on 2017/8/24.
 */

public class DialogActivity extends AppCompatActivity implements View.OnClickListener{

    Button dialogqueren;
    Button dialogdanxuan;
    Button dialogduoxuan;
    Button dialogliebiao;
    Button dialogzdy;

    String[] singlechoice = {"男","女"};
    String[] multichoice = {"篮球","足球","羽毛球"};
    String[] items = {"体育部","科技部","学术部"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        initWidget();

        initListener();
    }

    /**
     * 初始化控件
     */
    public void initWidget(){
        dialogqueren = (Button)findViewById(R.id.dialogqueren);
        dialogdanxuan = (Button)findViewById(R.id.dialogdanxuan);
        dialogduoxuan = (Button)findViewById(R.id.dialogduoxuan);
        dialogliebiao = (Button)findViewById(R.id.dialogliebiao);
        dialogzdy = (Button)findViewById(R.id.dialogzdy);
    }

    /**
     * 设置监听事件
     */
    public void initListener(){
        dialogqueren.setOnClickListener(this);
        dialogdanxuan.setOnClickListener(this);
        dialogduoxuan.setOnClickListener(this);
        dialogliebiao.setOnClickListener(this);
        dialogzdy.setOnClickListener(this);
    }

    /**
     * 显示dialog的方式
     */
    private void dialogShow(int i){
        AlertDialog.Builder builder;

        switch (i){
            case 1:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("确认对话框");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMessage("提示内容");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this,"确定",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case 2:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("性别");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setSingleChoiceItems(singlechoice, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String str = singlechoice[i];
                        Toast.makeText(DialogActivity.this,str,Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog2 = builder.create();
                dialog2.show();
                break;
            case 3:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("爱好");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setMultiChoiceItems(multichoice, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        String str2 = multichoice[i];
                        if(b){
                            Toast.makeText(DialogActivity.this,str2,Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(DialogActivity.this,"不"+str2,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog3 = builder.create();
                dialog3.show();
                break;
            case 4:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("部门");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DialogActivity.this,items[i],Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog4 = builder.create();
                dialog4.show();
                break;
            case 5:
                LayoutInflater inflater = LayoutInflater.from(this);
                View view = inflater.inflate(R.layout.dialoglayout,null);
                builder = new AlertDialog.Builder(this);
                builder.setTitle("自定义");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setView(view);
                AlertDialog dialog5 = builder.create();
                dialog5.show();
                break;
            default:
                break;
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.dialogqueren:
                //确认对话框
                dialogShow(1);
                break;
            case R.id.dialogdanxuan:
                //单选对话框
                dialogShow(2);
                break;
            case R.id.dialogduoxuan:
                //多选对话框
                dialogShow(3);
                break;
            case R.id.dialogliebiao:
                //列表对话框
                dialogShow(4);
                break;
            case R.id.dialogzdy:
                //自定义对话框
                dialogShow(5);
                break;
            default:
                break;
        }
    }
}
