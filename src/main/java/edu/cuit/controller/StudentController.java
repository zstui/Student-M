package edu.cuit.controller;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Uptask;
import edu.cuit.mapper.TeacherMapper;
import edu.cuit.service.StudentService;
import edu.cuit.service.TeacherService;
import edu.cuit.service.impl.StudentServiceimpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;


//    跳转到学生个人信息界面
    @RequestMapping(value = "/student/info")
    public ModelAndView showpersonal(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sinfo");
        return modelAndView;
    }

//    更新个人信息

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

//    根据班级id查询pubtask并跳转到课程中心
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

//    获取pubtask
    @RequestMapping(value = "/student/gettask")
    public ModelAndView gettask(@PathVariable("title") String title, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Student student =(Student) session.getAttribute("student");
        List<Pubtask> pubtask = studentService.FindPubtaskByTitle(title,student.getCid());
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("pubtask",pubtask);
        modelAndView.setViewName("up-task");
        return modelAndView;
    }

//    传输文件
    @RequestMapping(value = "/student/uptaskfile.do")
    @ResponseBody
    public String uptask(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/uptask");
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File file1 = new File(realPath,date);
        if (!file1.exists()){
            file1.mkdirs();
        }
        String filename= file.getOriginalFilename();
        filename = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
        file.transferTo(new File(file1,filename));
//        response.getWriter().write("<script>alert('上传成功!');window.location='../pages/smain.jsp'; </script>");
        return "smain";
    }
}
