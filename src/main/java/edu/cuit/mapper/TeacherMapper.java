package edu.cuit.mapper;

import edu.cuit.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
    public Student findBySnum(int snum);
    @Insert("insert into teacher values(#{Id},#{tname},#{tnum},#{tsex},#{tage},#{tstatus},#{phone},#{address},#{email},#{pwd},#{entime},#{pic})")
    public void save(Student student);
    @Delete("delete from teacher where tnum=#{tnum}")
    public void deleteBySnum(int snum);

}
