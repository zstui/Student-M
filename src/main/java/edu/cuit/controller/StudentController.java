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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ModelAndView gettask(@RequestParam("title") String title, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Student student =(Student) session.getAttribute("student");
        Pubtask pubtask = studentService.FindPubtaskByTitle(title,student.getCid());
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("pubtask",pubtask);
        modelAndView.setViewName("up-task");
        return modelAndView;
    }


//    @RequestMapping(value = "/student/gettask")
//    public ModelAndView gettask(@Param("title") String title, HttpServletRequest request){
//        HttpSession session = request.getSession(true);
//        Student student =(Student) session.getAttribute("student");
//        List<Pubtask> pubtask = studentService.FindAllPubtaskBycid(student.getCid());
//        ModelAndView modelAndView =new ModelAndView();
//        modelAndView.addObject("pubtask",pubtask);
//        modelAndView.setViewName("up-task");
//        return modelAndView;
//    }

    @RequestMapping(value = "/studnet/uptask")
    public ModelAndView uptask(){
        ModelAndView modelAndView = new ModelAndView();




        return modelAndView;
    }
    @RequestMapping(value = "/student/grade")
    public ModelAndView gradelist(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession(true);
        Student student = (Student) session.getAttribute("student");
        List<Uptask> uptaskList=studentService.finduptaskBySid(student.getSid());
        modelAndView.addObject("uptasklist",uptaskList);
        modelAndView.setViewName("sgradelist");


        return modelAndView;
    }
    @RequestMapping(value = "/student/uptaskfile.do")
    @ResponseBody
    public String submituptask(@RequestParam("pubid") Integer pubid,
                               @RequestParam("title") String title,
                               @RequestParam("article") String article,
                               @RequestParam(value = "file",required = false) CommonsMultipartFile file,
                               HttpServletRequest request,
                               HttpServletResponse response) throws IOException {

        Uptask uptask=studentService.submitUptaskinfo(pubid,title,article,file,request);
        studentService.submitUptaskAll(uptask);
        response.getWriter().write("<script>alert('submit it already!');window.location='course'; </script>");
        return null;
    }
    @RequestMapping(value = "/student/uptaskfile1.do")
    @ResponseBody
    public Map<String,String> uptask(MultipartFile file,HttpServletRequest request) throws IOException {
        Map<String,String> ret = new HashMap<String,String>();
        if (file.getSize() > 1024*1024*10){
            ret.put("type","error");
            ret.put("msg","文件大小不能超过10M");
            return ret;
        }
        String realPath = request.getSession().getServletContext().getRealPath("uptask/");
        String filename = file.getOriginalFilename();
        String name= filename.substring(filename.lastIndexOf("."));
        File file1 = new File(realPath,name);
        if (!file1.exists()){
            file1.mkdir();
        }
        file.transferTo(file1);
        ret.put("type","success");
        ret.put("filepath","uptask/");
        return ret;
    }
}
