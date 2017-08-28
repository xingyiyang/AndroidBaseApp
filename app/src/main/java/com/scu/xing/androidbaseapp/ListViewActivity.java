package com.scu.xing.androidbaseapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.scu.xing.androidbaseapp.listview.Student;
import com.scu.xing.androidbaseapp.listview.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xing on 2017/8/28.
 */

public class ListViewActivity extends AppCompatActivity{

    //定义数据
    private List<Student> studentList;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        listView = (ListView)findViewById(R.id.listviewzdy);
        LayoutInflater inflater = getLayoutInflater();

        //初始化数据
        initData();
        //创建自定义Adapter的对象
        StudentAdapter adapter = new StudentAdapter(studentList,inflater);
        listView.setAdapter(adapter);
    }

    /**
     * 初始化数据
     */
    private void initData(){
        studentList = new ArrayList<Student>();
        Student stu1 = new Student(R.mipmap.img_1,"张三", "10", "男", "喜欢玩");
        Student stu2 = new Student(R.mipmap.img_2,"李四", "11", "女", "喜欢玩游");
        Student stu3 = new Student(R.mipmap.img_3,"王五", "12", "男", "喜欢玩游戏");
        Student stu4 = new Student(R.mipmap.img_4,"赵六", "13", "女", "喜欢玩游");
        Student stu5 = new Student(R.mipmap.img_5,"fty", "14", "男", "喜欢玩");
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);
        studentList.add(stu4);
        studentList.add(stu5);
    }
}
