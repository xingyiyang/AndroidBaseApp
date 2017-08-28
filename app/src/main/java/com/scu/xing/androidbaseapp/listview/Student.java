package com.scu.xing.androidbaseapp.listview;

/**
 * Created by xing on 2017/8/28.
 */

public class Student {

    private int imag;     //学生照片
    private String name;  //学生姓名
    private String age;   //学生年龄
    private String sex;   //学生性别
    private String hobby; //学生爱好

    public Student(int imag, String name, String age, String sex, String hobby) {
        this.imag = imag;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
