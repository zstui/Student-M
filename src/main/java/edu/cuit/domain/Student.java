package edu.cuit.domain;

public class Student {
//    学生id
    private Integer sid;
//    学生姓名
    private String sname;
//    学生学号
    private Integer snum;
//    学生性别
    private String ssex;
//    学生年龄
    private Integer sage;
//    学生班级
    private Integer cid;
//    学生状态
    private String sstatus;
//    学生电话
    private Integer phone;
//    学生地址
    private String address;
//    学生邮箱
    private String email;
//    学生入学时间
    private String entime;
//    学生头像
    private String pic;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEntime() {
        return entime;
    }

    public void setEntime(String entime) {
        this.entime = entime;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }


    public Student(){

    }

    public Student(Integer sid, String sname, Integer snum, String ssex, Integer sage, Integer cid, String sstatus, Integer phone, String address, String email, String entime, String pic,String pwd) {
        this.sid = sid;
        this.sname = sname;
        this.snum = snum;
        this.ssex = ssex;
        this.sage = sage;
        this.cid = cid;
        this.sstatus = sstatus;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.entime = entime;
        this.pic = pic;
        this.pwd=pwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", snum=" + snum +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", cid=" + cid +
                ", sstatus='" + sstatus + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", entime='" + entime + '\'' +
                ", pic='" + pic + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
