package edu.cuit.service;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Uptask;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface StudentService {
    public Student FindBynum(String snum);

    public List<Uptask> FindAllUptaskBycid(Integer cid);

//    public List<Pubtask> FindAllPubtaskByPubid(Integer Pubid);
//
//    public List<Pubtask> FindAllPubtaskBySnum(String sname);
//
//    public List<Pubtask> FindAllPubtask();

    public void UpdateUptask(Uptask uptask);

    public void InsertUptask(Uptask uptask);

    public void DeleteUptask(Uptask uptask);

    public void UpdateInfo(Student student);

    public List<Pubtask> FindAllPubtaskBycid(Integer Cid);

    public Pubtask FindPubtaskByTitle(String title,Integer cid);

    public List<Student> findAll();

    public void insertStudent(Student student);

    public void deleteBysnum(String snum);
    public String submitUptask(CommonsMultipartFile file, HttpServletRequest request) throws IOException;

    public void submitUptaskAll(Uptask uptask);

    public Uptask submitUptaskinfo(Integer pubid, String title, String article, CommonsMultipartFile file, HttpServletRequest request) throws IOException;

    public List<Uptask> finduptaskBySid(Integer sid);
}
