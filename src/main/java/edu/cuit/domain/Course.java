package edu.cuit.domain;

public class Course {
    //    课程id
    private Integer courseid;
    //    课程名称
    private String coursename;


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


    public Course(){

    }


    public Course(Integer courseid, String coursename) {
        this.courseid = courseid;
        this.coursename = coursename;
    }

    @Override
    public String toString() {
        return "course{" +
                "courseid=" + courseid +
                ", coursename='" + coursename + '\'' +
                '}';
    }
}
