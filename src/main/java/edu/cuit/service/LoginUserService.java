package edu.cuit.service;

import edu.cuit.domain.Student;

public interface LoginUserService {
    public Student verifyUser(int num, String pwd);
}
