package com.wen.a1;

/**
 * Created by asus1 on 2018/4/27.
 */

public class Student {

    private String name;
    private String password;
    private String sex;
    private String department;
    private String major;
    private int number;

    public Student(String name, String sex, String department, String major, int number) {
        super();
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.major = major;
        this.number = number;
    }

    public Student(String name, String password,String sex, String department, String major, int number) {
        super();
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.department = department;
        this.major = major;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "姓名：" + name + "\n\n性别：" + sex + "\n\n院系：" + department + "\n\n专业：" + major + "\n\n宿舍：" + number ;
    }

}
