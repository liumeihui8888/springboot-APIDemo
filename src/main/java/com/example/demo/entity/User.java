package com.example.demo.entity;


public class User{
    String username;
    String password;
    String icon;
    String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(){}
    public User(String username,String password,String icon){
        this.username=username;
        this.password=password;
        this.icon=icon;
    }
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String toString (){
        return "user{name='"+username+"\',"+"password="+password+"}";
    }
}
