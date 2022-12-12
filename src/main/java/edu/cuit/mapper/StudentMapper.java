package edu.cuit.mapper;

import edu.cuit.domain.Student;
import org.apache.ibatis.annotations.*;

public interface StudentMapper {
//    @Select("select * from course")
//    @Results({
//            @Result(column = "Course_id",property = "id"),
//            @Result(column = "Course_name",property = "name"),
//            @Result(column = "Course_Specialty",property = "specialty"),
//
//    })
//    public List<Course> findAll();*/
    @Select("select * from student  where snum=#{snum}")
    public Student findBySnum(int snum);
    @Insert("insert into student values(#{Id},#{sname},#{snum},#{ssex},#{sage},#{cid},#{sstatus},#{phone},#{address},#{email},#{pwd},#{entime},#{pic})")
    public void save(Student student);
    @Delete("delete from student where snum=#{snum}")
    public void deleteBySnum(int snum);

}
