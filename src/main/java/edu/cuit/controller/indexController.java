package edu.cuit.controller;


import edu.cuit.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {


    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    public ModelAndView doCheck(@RequestParam("uname") String uname, @RequestParam("upassword") String upassword){

        ModelAndView modelAndView = new ModelAndView();
        if (uname.equals("admin") && (upassword.equals("123"))){
            User loginuser= new User();
            loginuser.setUname(uname);
            loginuser.setUpassword(upassword);
            modelAndView.addObject("user",loginuser);
            modelAndView.setViewName("success");
        }
        else{
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }






}
