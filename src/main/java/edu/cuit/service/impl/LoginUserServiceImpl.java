package edu.cuit.service.impl;

import edu.cuit.domain.Student;
import edu.cuit.mapper.StudentMapper;
import edu.cuit.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginUserService")
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired



    @Override
    public Student verifyUser(int num,String pwd){
        Student student = studentMapper.findBySnum(num);
        if(student.getPwd().equals(pwd)){
            return student;
        }else {
            return null;
        }


    }
}
