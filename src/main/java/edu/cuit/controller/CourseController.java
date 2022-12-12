package edu.cuit.controller;

import edu.cuit.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
  /*  @Autowired
    private CourseMapper courseMapper;
    
    @RequestMapping("/list")
    public ModelAndView findAll(){
        List<Course> courseList = courseMapper.findAll();
        System.out.println(courseList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courseList",courseList);
        modelAndView.setViewName("questionBank");
        return modelAndView;

    }*/
}
