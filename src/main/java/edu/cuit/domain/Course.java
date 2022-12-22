package edu.cuit.domain;

public class Course {
    //    课程id
    private Integer courseid;
    //    课程名称
    private String coursename;

    private String tname;

    private String coursetask;
    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCoursetask() {
        return coursetask;
    }

    public void setCoursetask(String coursetask) {
        this.coursetask = coursetask;
    }

    public Course(){

    }


    public Course(Integer courseid, String coursename, String tname, String coursetask) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.tname = tname;
        this.coursetask = coursetask;
    }

    public Course(Integer courseid, String coursename, String tname) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                ", tname='" + tname + '\'' +
                ", coursetask='" + coursetask + '\'' +
                '}';
    }
}
