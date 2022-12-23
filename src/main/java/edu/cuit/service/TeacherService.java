package edu.cuit.service;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Teacher;
import edu.cuit.domain.Uptask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface TeacherService {
    public Teacher findBytnum(String tnum);


    public void updatePubtask(Pubtask pubtask);

    public Pubtask findPubtaskById(Integer id);

    public void insertPubtask(Pubtask pubtask);

    public List<Pubtask> FindAllPubtask();
    public List<Pubtask> FindAllPubtaskByTnum(Integer tnum);

    public void deteletPubtaskById(Integer id);


   public List<Uptask> FindAlluptaskByPubid(Integer id);

    public  void updateInfo(Teacher teacher);

    public void updateUptask(Uptask uptask);

    public Integer updateGrade(Integer grade,Integer aid);

    public Uptask findUptask(Integer aid);

    public List<Teacher> findAll();

    public void insertTeacher(Teacher teacher);

    public void deleteByTnum(String tnum);
    void downlaodFile(Integer aid, HttpServletRequest request, HttpServletResponse response) throws IOException;
}
