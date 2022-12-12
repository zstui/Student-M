package edu.cuit.domain;

public class Approval {
//请求id
    private Integer aid;
//学生id
    private Integer sid;
//标题
    private String title;
//原因
    private String reason;
//类型
    private String type;
//申请时间
    private String aDate;
//申请状态
    private String status;
//附件名称
    private String attName;
//附件
    private String att;
//回复消息
    private String msg;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getaDate() {
        return aDate;
    }

    public void setaDate(String aDate) {
        this.aDate = aDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAttName() {
        return attName;
    }

    public void setAttName(String attName) {
        this.attName = attName;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Approval(){

    }

    public Approval(Integer aid, Integer sid, String title, String reason, String type, String aDate, String status, String attName, String att, String msg) {
        this.aid = aid;
        this.sid = sid;
        this.title = title;
        this.reason = reason;
        this.type = type;
        this.aDate = aDate;
        this.status = status;
        this.attName = attName;
        this.att = att;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "approval{" +
                "aid=" + aid +
                ", sid=" + sid +
                ", title='" + title + '\'' +
                ", reason='" + reason + '\'' +
                ", type='" + type + '\'' +
                ", aDate='" + aDate + '\'' +
                ", status='" + status + '\'' +
                ", attName='" + attName + '\'' +
                ", att='" + att + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
