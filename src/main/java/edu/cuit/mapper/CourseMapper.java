package edu.cuit.mapper;

import edu.cuit.domain.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {

    @Select("select * from course")
    public List<Course> findAll();

    @Insert("insert into course VALUES (#{courseid},#{coursename},#{tname},#{coursetask})")
    public void InsertCourse(Course course);

    @Update("update course set courseid=#{courseid},courseName=#{coursename},tname=#{tname},coursetask=#{coursetask}\n" +
            "            where courseid=#{courseid}")
    public void UpdateCourse(Course course);

    @Delete("delete from course where courseid=#{courseid}")
    public void DeleteByCourseid(Integer courseid);








/*    @Select("select * from course")
    @Results({
            @Result(column = "Course_id",property = "id"),
            @Result(column = "Course_name",property = "name"),
            @Result(column = "Course_Specialty",property = "specialty"),

    })
    public List<Course> findAll();*/

}
