package com.forum.entity;

public class User {
    private String user_id;//用户ID
    private String user_name;//用户名
    private String user_pwd;//用户密码
    private int sex;//用户性别
    private int age;//用户年龄
    private String user_add;//用户住址
    private String user_mail;//用户邮箱
    private String phone;//用户手机号
    private int level;//用户权限
    private int status;//用户状态

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUser_add() {
        return user_add;
    }

    public void setUser_add(String user_add) {
        this.user_add = user_add;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", user_add='" + user_add + '\'' +
                ", user_mail='" + user_mail + '\'' +
                ", phone='" + phone + '\'' +
                ", level=" + level +
                ", status=" + status +
                '}';
    }
}
