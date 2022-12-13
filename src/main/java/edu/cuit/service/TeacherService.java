package edu.cuit.service;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher findBytnum(String tnum);


    public void updatePubtask(Pubtask pubtask);

    public void insertPubtask(Pubtask pubtask);

    public List<Pubtask> FindAllPubtask();
    public List<Pubtask> FindAllPubtaskByTnum(Integer tnum);

    public void deteletPubtaskById(Integer id);

}
