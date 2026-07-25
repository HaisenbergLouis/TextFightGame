package com.soren.domain;

import java.util.Random;

public class User {
    private String id;
    private String name;
    private String password;
    private Boolean status;

    public User(){
        id= CreateID();
        //默认状态为true，否则用户刚注册账号就被禁用
        status = true;

    }
    public User(String name, String password){
        id= CreateID();
        this.name = name;
        this.password = password;
        status = true;
    }

//    用户无法设置，是自动生成的，格式为：heima+5位数字的随机
    public String CreateID(){
        StringBuilder sb = new StringBuilder("soren");

        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int num = r.nextInt(10);
            sb.append(num);
        }
        return sb.toString();




    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
