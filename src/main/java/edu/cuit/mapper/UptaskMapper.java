package edu.cuit.mapper;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Teacher;
import edu.cuit.domain.Uptask;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UptaskMapper {

    //管理员
    // 查看所有提交作业
    @Select("select * from uptask")
    public List<Uptask> findAll();
    //教师
    // 通过自己id查看自己发布task
    @Select("select * from uptask where tid=#{tid}")
    public List<Uptask> findAllByTid(Teacher teacher);
    @Select("select pubid from uptask where aid=#{aid}")
    public Integer findAllByAid(Integer aid );
    //学生
    // 通过sid查看自己完成的作业
    @Select("select * from uptask where sid=#{sid}")
    public  List<Uptask> findAllByCid(Student student);
    @Select("select * from uptask where pubid=#{pubid}")
    public List<Uptask> findAllByPubid(Integer pubid);

    @Select("select * from uptask where aid=#{aid}")
    public Uptask findByaid(Integer aid);
    //通用
    @Update("update uptask set aid=#{aid},sid=#{sid},tid=#{tid},title=#{title},article=#{article} datetime=#{datetime},status=#{status},attName=#{attName},att=#{att},msg=#{msg} grade=#{grade} where aid =#{aid}")
    public void update(Uptask uptask);
    @Update("update uptask set grade=#{grade} ,status='已批阅'  where aid =#{aid}")
    public void updateGrade(@Param("grade") Integer grade,@Param("aid") Integer aid );
    @Delete("delete from uptask where id=#{id}")
    public void delete(Uptask uptask);
    @Insert("insert into uptask values(#{aid},#{sid},tid=#{tid},#{article},#{datetime},#{status},#{attName},#{att},#{msg} #{grade})")
    public void insert(Uptask uptask);
    @Select("select * from uptask where sid=#{sid}")
    List<Uptask> findAllBySid(Integer sid);

}
