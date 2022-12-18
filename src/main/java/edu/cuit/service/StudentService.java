package edu.cuit.service;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Uptask;

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
}
