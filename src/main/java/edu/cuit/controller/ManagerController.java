package edu.cuit.controller;


import edu.cuit.domain.Course;
import edu.cuit.domain.Manager;
import edu.cuit.domain.Student;
import edu.cuit.domain.Teacher;
import edu.cuit.service.CourseService;
import edu.cuit.service.ManagerService;
import edu.cuit.service.StudentService;
import edu.cuit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;


//   更新个人信息

    @RequestMapping(value = "/manager/updateinfo.do")
    @ResponseBody
    public String updateinfo(Manager manager,HttpServletResponse response,HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession(true);
        managerService.UpdateInfo(manager);
        Manager manager1 = managerService.findMByusername(manager.getMusername());
        session.setAttribute("manager",manager1);
        response.getWriter().write("<script>alert('update it success!');window.location='../pages/minfo.jsp'; </script>");
        return null;
    }

//    跳转到个人信息页

    @RequestMapping(value = "/manager/info")
    public ModelAndView showinfo(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("minfo");
        return modelAndView;
    }

//       查询所有管理员，成功则跳转到管理管理员界面

    @RequestMapping(value = "/manager/m-manager")
    public ModelAndView managemanager(){
//        HttpSession session = request.getSession(true);
//        Manager manager = (Manager) session.getAttribute("manager");
        List<Manager> managerList = managerService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("managerList",managerList);
        modelAndView.setViewName("m-manager");
        return modelAndView;
    }

//  删除管理员

    @RequestMapping(value = "/manager/deletemanager.do")
    @ResponseBody
    public String deletemanager(@RequestParam("musername") String musername , HttpServletResponse response) throws IOException {
        managerService.deleteByMusername(musername);
        response.getWriter().write("<script>alert('Delete it success!');window.location='../pages/mmain.jsp'; </script>");
        return null;
    }

//    获取form表单的数据进行插入数据

    @RequestMapping(value = "/manager/manager-add.do",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView manageradd(Integer mid,String musername,String pwd,String mname){
        Manager manager = new Manager(mid,musername,pwd,mname);
        managerService.insertManager(manager);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mmain");
        return modelAndView;
    }

//    查询所有教师，成功则跳转到管理教师界面

    @RequestMapping(value = "/manager/m-teacher")
    public ModelAndView manageteacher(){
        List<Teacher> teacherList = teacherService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teacherList",teacherList);
        modelAndView.setViewName("m-teacher");
        return modelAndView;
    }

//    添加教师

    @RequestMapping(value = "/manager/teacher-add.do",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView teacheradd(Integer tid,String tname,String tnum,String tsex,Integer tage,String tstatus,String phone,
                                   String address,String email,String pwd){
        Teacher teacher = new Teacher(tid,tname,tnum,tsex,tage,tstatus,phone,address,email,pwd);
        teacherService.insertTeacher(teacher);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mmain");
        return modelAndView;
    }

//    删除教师

    @RequestMapping(value = "/manager/deleteteacher.do")
    @ResponseBody
    public String deleteteacher(@RequestParam("tnum") String tnum,HttpServletResponse response) throws IOException {
        teacherService.deleteByTnum(tnum);
        response.getWriter().write("<script>alert('Delete it success!');window.location='../pages/mmain.jsp'; </script>");
        return null;
    }

//    查询所有学生，成功则跳转到管理学生界面

    @RequestMapping(value = "/manager/m-student")
    public ModelAndView managestudent(){
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("studentList",studentList);
        modelAndView.setViewName("m-student");
        return modelAndView;
    }

//     添加学生

    @RequestMapping(value = "/manager/student-add.do",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView studentadd(Integer sid,String sname,String snum,String ssex,Integer sage,Integer cid,String sstatus,Integer phone,
                                   String address,String email,String entime,String pwd){
        Student student = new Student(sid,sname,snum,ssex,sage,cid,sstatus,phone,address,email,entime,pwd);
        studentService.insertStudent(student);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mmain");
        return modelAndView;
    }

//    删除学生

    @RequestMapping(value = "/manager/deletestudent.do")
    @ResponseBody
    public String deletestudent(@RequestParam("snum") String snum,HttpServletResponse response) throws IOException {
        studentService.deleteBysnum(snum);
        response.getWriter().write("<script>alert('Delete it success!');window.location='../pages/mmain.jsp'; </script>");
        return null;
    }

//    查询所有课程，成功则跳转到管理课程界面

    @RequestMapping(value = "/manager/m-course")
    public ModelAndView managercourse(){
        List<Course> courseList =courseService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("courseList",courseList);
        modelAndView.setViewName("m-course");
        return modelAndView;
    }

//    添加课程

    @RequestMapping(value = "/manager/course-add.do",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView courseadd(Integer courseid,String coursename,String tname){
        Course course = new Course(courseid,coursename,tname);
        courseService.InsertCourse(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mmain");
        return modelAndView;
    }
//    删除课程

    @RequestMapping(value = "/manager/deletecourse.do")
    @ResponseBody
    public String deletecourse(@RequestParam("courseid") Integer courseid,HttpServletResponse response) throws IOException {
        courseService.DeleteByCourseId(courseid);
        response.getWriter().write("<script>alert('Delete it success!');window.location='../pages/mmain.jsp'; </script>");
        return null;
    }
//    更新课程
    @RequestMapping(value = "/manager/course-update.do")
    @ResponseBody
    public ModelAndView courseupdate(Integer courseid,String coursename,String tname){
        Course course = new Course(courseid,coursename,tname);
        courseService.UpdateCourse(course);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mmain");
        return modelAndView;
    }
}
