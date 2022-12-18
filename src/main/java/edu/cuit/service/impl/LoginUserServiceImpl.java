package edu.cuit.service.impl;

import edu.cuit.domain.Manager;
import edu.cuit.domain.Student;
import edu.cuit.domain.Teacher;
import edu.cuit.mapper.ManagerMapper;
import edu.cuit.mapper.StudentMapper;
import edu.cuit.mapper.TeacherMapper;
import edu.cuit.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginUserService")
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    public Object verifyUser(String num, String pwd, String author){

        if(author.equals("student")){
            Student student = studentMapper.findBySnum(num);
            if(student==null)
                return null;
            if(student.getPwd().equals(pwd)){
                return student;
            }else {
                return null;
            }

        }else if(author.equals("teacher")){
            Teacher teacher = teacherMapper.findBytnum(num);
            if(teacher==null)
                return null;
            if(teacher.getPwd().equals(pwd)){
                return teacher;
            }else {
                return null;
            }

        }else{
            Manager manager = managerMapper.findByMusername(num);
            if(manager==null)
                return null;
            if(manager.getPwd().equals(pwd)){
                return manager;
            }else {
                return null;
            }

        }



    }
}
