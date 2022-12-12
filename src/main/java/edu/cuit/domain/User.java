package edu.cuit.domain;

public class User {
    private String uname;
    private String upassword;
    public User(){}
    public User(String name, String pwd) {
        this.uname=name;
        this.upassword=pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                '}';
    }
}
