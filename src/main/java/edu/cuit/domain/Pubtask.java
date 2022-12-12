package edu.cuit.domain;

public class Pubtask {
    private int id;
    private int tid;
    private int courseid;
    private int cid;
    private String title;
    private String article;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    @Override
    public String toString() {
        return "Pubtask{" +
                "id=" + id +
                ", tid=" + tid +
                ", courseid=" + courseid +
                ", cid=" + cid +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                '}';
    }
}
