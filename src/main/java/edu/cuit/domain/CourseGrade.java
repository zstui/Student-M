package edu.cuit.domain;

public class CourseGrade {
//    课程id
    private Integer courseid;
//    学生姓名
    private String sname;
//    学生成绩
    private Integer score;

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public CourseGrade(){

    }

    public CourseGrade(Integer courseid, String sname, Integer score) {
        this.courseid = courseid;
        this.sname = sname;
        this.score = score;
    }


    @Override
    public String toString() {
        return "courseGrade{" +
                "courseid=" + courseid +
                ", sname='" + sname + '\'' +
                ", score=" + score +
                '}';
    }
}
