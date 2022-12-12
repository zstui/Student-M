package edu.cuit.mapper;

import edu.cuit.domain.Course;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {

    @Select("select * from course")
    public List<Course> findAll();


/*    @Select("select * from course")
    @Results({
            @Result(column = "Course_id",property = "id"),
            @Result(column = "Course_name",property = "name"),
            @Result(column = "Course_Specialty",property = "specialty"),

    })
    public List<Course> findAll();*/

}
