package edu.cuit.mapper;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PubtaskMapper {

    //管理员
    // 查看所有发布作业
    @Select("select * from pubtask")
    public List<Pubtask> findAll();
    //教师
    // 通过自己id查看自己发布task
    @Select("select * from pubtask where tid=#{tid}")
    public List<Pubtask> findAllByTid(Teacher teacher);
    //学生
    // 通过班级cid查看老师发布的任务
    @Select("select * from pubtask where cid=#{cid}")
    public  List<Pubtask> findAllByCid(Student student);

    //通用
    @Update("update pubtask set tid=#{tid},courseid=#{courseid},cid=#{cid},title=#{title},article=#{article} where id =#{id}")
    public void update(Pubtask pubtask);
    @Delete("delete from pubtask where id=#{id}")
    public void delete(Pubtask pubtask);
    @Insert("insert into pubtask values(#{id},#{tid},#{courseid},#{cid},#{title},#{article})")
    public void insert(Pubtask pubtask);
}
