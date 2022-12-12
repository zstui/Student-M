package edu.cuit.domain;

public class Information {
//    id
    private Integer id;
//    标题
    private String title;
//    添加人
    private String people;
//    添加时间
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Information(){

    }

    public Information(Integer id, String title, String people, String date) {
        this.id = id;
        this.title = title;
        this.people = people;
        this.date = date;
    }

    @Override
    public String toString() {
        return "information{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", people='" + people + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
