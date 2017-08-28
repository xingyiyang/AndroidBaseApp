package com.scu.xing.androidbaseapp.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.scu.xing.androidbaseapp.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by xing on 2017/8/28.
 */

public class StudentAdapter extends BaseAdapter{

    private List<Student> studentData;
    private LayoutInflater inflater;   //加载自定义的listview的item布局

    /**
     * 定义构造器，在Activity创建对象Adapter的时候将数据data和Inflater传入自定义的Adapter中进行处理
     * @param studentData
     * @param inflater
     */
    public StudentAdapter(List<Student> studentData, LayoutInflater inflater) {
        this.studentData = studentData;
        this.inflater = inflater;
    }

    /**
     * 返回数据的数量
     * @return
     */
    @Override
    public int getCount() {
        return studentData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 该方法是自定义Adapter最重要的方法，在这个方法中我们需要将数据一一对应的映射或者添加到我们自己定义的View中。然后返回view。
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View viewStudent = inflater.inflate(R.layout.listviewzdy,null);
        Student student = studentData.get(position);

        //获取自定义布局中的每一个控件的对象
        ImageView imagephoto = (ImageView)viewStudent.findViewById(R.id.image_photo);
        TextView name = (TextView)viewStudent.findViewById(R.id.textview_name);
        TextView age = (TextView)viewStudent.findViewById(R.id.textview_age);
        TextView sex = (TextView)viewStudent.findViewById(R.id.textview_sex);
        TextView hobby = (TextView)viewStudent.findViewById(R.id.textview_hobby);
        //将数据一一添加到自定义的布局中
        imagephoto.setImageResource(student.getImag());
        name.setText(student.getName());
        age.setText(student.getAge());
        sex.setText(student.getSex());
        hobby.setText(student.getHobby());

        return viewStudent;
    }
}
