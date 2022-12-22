package edu.cuit.mapper;

import edu.cuit.domain.Student;
import edu.cuit.domain.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
//    @Select("select * from course")
//    @Results({
//            @Result(column = "Course_id",property = "id"),
//            @Result(column = "Course_name",property = "name"),
//            @Result(column = "Course_Specialty",property = "specialty"),
//
//    })
//    public List<Course> findAll();*/

    //简单的增删改查
    @Select("select * from student  where snum=#{snum}")
    public Student findBySnum(String snum);

    @Insert("insert into student values(#{sid},#{sname},#{snum},#{ssex},#{sage},#{cid},#{sstatus},#{phone},#{address},#{email},#{pwd},#{entime},#{pic})")
    public void save(Student student);
    @Delete("delete from student where snum=#{snum}")
    public void deleteBySnum(String snum);
    @Select("select * from student")
    public List<Student> findAll();
    @Update("update student set sname=#{snum},ssex=#{ssex}," +
            "sage=#{sage},cid=#{cid},sstatus=#{sstatus},phone=#{phone},address=#{address},email=#{email},pwd=#{pwd},pic=#{pic} where sid=#{sid}")
    public  void update(Student student);


}
