package edu.cuit.domain;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

public class Uptask {
    private int aid;
    private int sid;
    private int tid;
    private String title;
    private String article;
    private Date date;
    private String status;
    private String attName;
    private String att;
    private String msg;
    private String grade;
    private int pubid;
    private List<MultipartFile> files;
    private String fileNameStr;
    private List<String> path;

    public int getPubid() {
        return pubid;
    }

    public void setPubid(int pubid) {
        this.pubid = pubid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public String getFileNameStr() {
        return fileNameStr;
    }

    public void setFileNameStr(String fileNameStr) {
        this.fileNameStr = fileNameStr;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Uptask{" +
                "aid=" + aid +
                ", sid=" + sid +
                ", tid=" + tid +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", attName='" + attName + '\'' +
                ", att='" + att + '\'' +
                ", msg='" + msg + '\'' +
                ", grade='" + grade + '\'' +
                ", pubid=" + pubid +
                '}';
    }
}
