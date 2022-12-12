package edu.cuit.mapper;

import edu.cuit.domain.CourseGrade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface CourseGradeMapper {

    @Select("select * from course_grade")
    public List<CourseGradeMapper> findAll();

    @Insert("insert into course_grade values(#{courseid},#{snum},#{score})")
    public void insert(CourseGradeMapper courseGrade);

    @Delete("delete from course_grade where cgid=#{cgid}")
    public void  delete(CourseGradeMapper courseGrade);
    @Update("update course_grade set courseid=#{courseid},snum=#{snum},score=#{score},cgid=#{cgid} ")
    public void update(CourseGrade courseGrade);
}
