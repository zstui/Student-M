package edu.cuit.controller;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Uptask;
import edu.cuit.mapper.TeacherMapper;
import edu.cuit.service.StudentService;
import edu.cuit.service.TeacherService;
import edu.cuit.service.impl.StudentServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


    @RequestMapping(value = "/student/info")
    public ModelAndView showpersonal(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sinfo");
        return modelAndView;
    }

//    @RequestMapping(value = "/student/course")
//    public ModelAndView docourse(){
//        ModelAndView modelAndView = new ModelAndView();
//        //待修改
////        List<Uptask> uptask = studentService.FindAllUptaskBycid(cid);
//        //
////        modelAndView.addObject(uptask);
//        modelAndView.setViewName("scourse");
//        return modelAndView;
//    }

    @RequestMapping(value = "/student/updateinfo.do")
    @ResponseBody
    public String updateinfo(Student student, HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession(true);
        studentService.UpdateInfo(student);
        Student student1=studentService.FindBynum(student.getSnum());
        session.setAttribute("student",student1);
        response.getWriter().write("<script>alert('update it success!');window.location='../pages/sinfo.jsp'; </script>");
        return null;
    }

    @RequestMapping(value = "/student/course")
    public ModelAndView stask(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");
        List<Pubtask> pubtaskList1 = studentService.FindAllPubtaskBycid(student.getCid());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pubtaskList1",pubtaskList1);
        modelAndView.setViewName("scourse");
        return modelAndView;
    }

    @RequestMapping(value = "/student/gettask")
    public ModelAndView gettask(@RequestParam("id") Integer id){
        Pubtask pubtask = teacherService.findPubtaskById(id);
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("pubtask",pubtask);
        modelAndView.setViewName("scourse");
        return modelAndView;
    }

    @RequestMapping(value = "/student/findtask")
    @ResponseBody
    public String Findetask(@RequestParam("id") Integer id,HttpServletResponse response) throws IOException {
        response.getWriter().write("<<script>window.location='stask'; </script>>");
        return null;
    }
}
