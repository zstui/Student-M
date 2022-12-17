package edu.cuit.service.impl;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Uptask;
import edu.cuit.mapper.PubtaskMapper;
import edu.cuit.mapper.StudentMapper;
import edu.cuit.mapper.TeacherMapper;
import edu.cuit.mapper.UptaskMapper;
import edu.cuit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service("StudentService")
//public class StudentServiceimpl implements StudentService {
//    @Autowired
//    private TeacherMapper teacherMapper;
//
//    @Autowired
//    private StudentMapper studentMapper;
//
//    @Autowired
//    private UptaskMapper uptaskMapper;
//
//    @Autowired
//    private PubtaskMapper pubtaskMapper;
//
//    @Override
//    public Student FindBynum(String snum){
//        return studentMapper.findBySnum(snum);
//    }
//
//    @Override
//    public List<Uptask> FindAllUptaskBycid(Integer cid){
//        Student student=new Student();
//        student.setCid(cid);
//        return uptaskMapper.findAllByCid(student);
//    }
//
//}
