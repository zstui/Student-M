package edu.cuit.domain;

public class Teacher {
//     教师id
    private Integer tid;
//     教师名
    private String tname;
//     教师职工号
    private String tnum;
//     性别
    private String tsex;
//      年龄
    private Integer tage;
//     状态
    private String tstatus;
//     手机号
    private String phone;
//     地址
    private String address;
//     密码
    private String pwd;
//     照片地址
    private String pic;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTnum() {
        return tnum;
    }

    public void setTnum(String tnum) {
        this.tnum = tnum;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public Integer getTage() {
        return tage;
    }

    public void setTage(Integer tage) {
        this.tage = tage;
    }

    public String getTstatus() {
        return tstatus;
    }

    public void setTstatus(String tstatus) {
        this.tstatus = tstatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                ", tnum='" + tnum + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tage=" + tage +
                ", tstatus='" + tstatus + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", pswd='" + pwd + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
