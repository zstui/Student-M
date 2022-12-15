package edu.cuit.service;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Teacher;
import edu.cuit.domain.Uptask;

import java.util.List;

public interface TeacherService {
    public Teacher findBytnum(String tnum);


    public void updatePubtask(Pubtask pubtask);

    public Pubtask findPubtaskById(Integer id);

    public void insertPubtask(Pubtask pubtask);

    public List<Pubtask> FindAllPubtask();
    public List<Pubtask> FindAllPubtaskByTnum(Integer tnum);

    public void deteletPubtaskById(Integer id);


    List<Uptask> FindAlluptaskByPubid(Integer id);
}
