package edu.cuit.mapper;

import edu.cuit.domain.Student;
import edu.cuit.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeacherMapper {
//    @Select("select * from course")
//    @Results({
//            @Result(column = "Course_id",property = "id"),
//            @Result(column = "Course_name",property = "name"),
//            @Result(column = "Course_Specialty",property = "specialty"),
//
//    })
//    public List<Course> findAll();*/
    @Select("select * from teacher  where tnum=#{tnum}")
    public Teacher findBytnum(String tnum);
    @Select("select * from teacher")
    public List<Teacher> findAll();
    @Insert("insert into teacher values(#{Id},#{tname},#{tnum},#{tsex},#{tage},#{tstatus},#{phone},#{address},#{email},#{pwd},#{entime},#{pic})")
    public void save(Teacher teacher);
    @Delete("delete from teacher where tnum=#{tnum}")
    public void deleteBySnum(String snum);
    @Update("update teacher set tname=#{tnum},tsex=#{tsex}," +
            "tage=#{tage},tstatus=#{tstatus},phone=#{phone},address=#{address},email=#{email},pwd=#{pwd},pic=#{pic}")
    public  void update(Teacher teacher);


}
