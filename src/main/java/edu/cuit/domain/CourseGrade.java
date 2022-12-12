package edu.cuit.domain;

public class CourseGrade {
//    课程id
    private Integer courseid;
//    学生姓名
    private Integer snum;
//    学生成绩
    private Integer score;

    private Integer cgid;
    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }



    public Integer getCgid() {
        return cgid;
    }

    public void setCgid(Integer cgid) {
        this.cgid = cgid;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public CourseGrade(){

    }

    public CourseGrade(Integer courseid,Integer snum, Integer score,Integer cgid) {
        this.courseid = courseid;
        this.snum = snum;
        this.score = score;
        this.cgid = cgid;
    }


    @Override
    public String toString() {
        return "CourseGrade{" +
                "courseid=" + courseid +
                ", snum=" + snum +
                ", score=" + score +
                ", cgid=" + cgid +
                '}';
    }
}
