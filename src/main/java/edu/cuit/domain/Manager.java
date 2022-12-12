package edu.cuit.domain;

public class Manager {
//    管理员id
    private Integer mid;
//    管理员用户名
    private String musername;
//    管理员密码
    private String pwd;
//    管理员姓名
    private String mname;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }


    public Manager(){

    }


    public Manager(Integer mid, String musername, String pwd, String mname) {
        this.mid = mid;
        this.musername = musername;
        this.pwd = pwd;
        this.mname = mname;
    }


    @Override
    public String toString() {
        return "manager{" +
                "mid=" + mid +
                ", musername='" + musername + '\'' +
                ", pwd='" + pwd + '\'' +
                ", mname='" + mname + '\'' +
                '}';
    }
}
