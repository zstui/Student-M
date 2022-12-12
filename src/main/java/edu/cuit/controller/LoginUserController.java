package edu.cuit.controller;

import edu.cuit.domain.Student;
import edu.cuit.domain.User;
import edu.cuit.service.LoginUserService;
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

        @RequestMapping(value = "/user/login",method = RequestMethod.POST)
       public ModelAndView doCheck(@RequestParam("number") int number, @RequestParam("pwd") String pwd, @RequestParam("author") String author /*HttpServletRequest request*/){
           Student student= loginUserService.verifyUser(number,pwd);


            ModelAndView modelAndView = new ModelAndView();
            if (student!=null){
               /* HttpSession session = request.getSession();
                session.setAttribute("student",student);*/
                modelAndView.addObject("user",student);
                modelAndView.setViewName("main");
            }
            else{
                modelAndView.setViewName("error");}
            return modelAndView;
        }





}


