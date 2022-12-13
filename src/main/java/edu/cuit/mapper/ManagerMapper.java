package edu.cuit.mapper;

import edu.cuit.domain.Manager;
import edu.cuit.domain.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ManagerMapper {
    @Select("select * from manager where musername=#{musername}")
    public Manager findByMusername(String musername);
    @Select("select * from manager")
    public List<Manager> findAll();
    @Insert("insert into manager values(#{mid},#{musername},#{pwd},#{mname})")
    public void save(Manager manager);
    @Delete("delete from manager where musername=#{musername}")
    public void deleteByMusername(String musername);
    @Update("update teacher set mid=#{mid},musername=#{musername},pwd=#{pwd}," +
            "mname=#{mname}")
    public  void update(Manager manager);
}
