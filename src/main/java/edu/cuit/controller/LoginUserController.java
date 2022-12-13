package edu.cuit.controller;

import edu.cuit.domain.Student;
import edu.cuit.domain.Teacher;
import edu.cuit.domain.User;
import edu.cuit.service.LoginUserService;
import edu.cuit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginUserController {


    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private TeacherService teacherService;

        @RequestMapping(value = "/user/login",method = RequestMethod.POST)
       public ModelAndView doCheck(@RequestParam("number") String number, @RequestParam("pwd") String pwd, @RequestParam("author") String author,HttpServletRequest request){
           Object user= loginUserService.verifyUser(number,pwd,author);


            ModelAndView modelAndView = new ModelAndView();
            if (user!=null){
                HttpSession session = request.getSession(true);//�½�session����

                modelAndView.addObject("user",user);

                if(author.equals("student")){

                    modelAndView.setViewName("smain");
                }
                else if (author.equals("teacher")){
                    Teacher teacher=teacherService.findBytnum(number);
                    session.setAttribute("teacher",teacher);

                    modelAndView.setViewName("tmain");
                }else {
                    modelAndView.setViewName("mmain");
                }

            }
            else{
                modelAndView.setViewName("error");}
            return modelAndView;
        }





}


