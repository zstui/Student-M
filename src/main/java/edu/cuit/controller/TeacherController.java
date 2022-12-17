package edu.cuit.controller;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Teacher;
import edu.cuit.domain.Uptask;
import edu.cuit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacher/addtask")
    public ModelAndView toaddtask(){

      /*  Teacher user=teacherService.findBytnum(tnum);*/


        ModelAndView modelAndView = new ModelAndView();


       /* modelAndView.addObject("teacher",user);*/


        modelAndView.setViewName("task-add");




        return modelAndView;
    }

    @RequestMapping(value = "/teacher/addtask.action")
    @ResponseBody
    public String addtaskAction(Pubtask pubtask , HttpServletResponse response,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession(true);
        Teacher teacher= (Teacher) session.getAttribute("teacher");
        pubtask.setTid(teacher.getTid());
        teacherService.insertPubtask(pubtask);
        response.getWriter().write("<script>alert('pubTaskSuccessed!');window.location='../pages/task-add.jsp'; </script>");
        return null;



    }
    @RequestMapping(value = "/teacher/touptask")
    public ModelAndView touptask(@RequestParam("aid")Integer aid){
        Uptask uptask=teacherService.findUptask(aid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("uptask",uptask);
        modelAndView.setViewName("uptaskinfo");
        return modelAndView;
    }
    @RequestMapping(value = "/teacher/markuptask.action")
    public ModelAndView markuptaskAction(@RequestParam("aid")Integer aid ,@RequestParam("grade")Integer grade, HttpServletResponse response,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession(true);
        Teacher teacher= (Teacher) session.getAttribute("teacher");
        Integer CurrentId=teacherService.updateGrade(grade,aid);
        ModelAndView modelAndView = new ModelAndView("redirect:/teacher/uptasklist?id="+CurrentId);


        return modelAndView;



    }


    @RequestMapping(value = "/teacher/totask")
    public ModelAndView toatask(@RequestParam("id") Integer id){


        /*  Teacher user=teacherService.findBytnum(tnum);*/
        Pubtask pubtask = teacherService.findPubtaskById(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pubtask",pubtask);
        modelAndView.setViewName("updatetask");
        return modelAndView;
    }
    @RequestMapping(value = "/teacher/updatetask.action")
    @ResponseBody
    public String updatetaskAction(Pubtask pubtask , HttpServletResponse response) throws Exception{


        teacherService.updatePubtask(pubtask);
        response.getWriter().write("<script>alert('update it already!');window.location='tasklist'; </script>");
        return null;



    }
    @RequestMapping(value = "/teacher/updateinfo.action")
    @ResponseBody
    public String updatetinfo(Teacher teacher , HttpServletResponse response,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession(true);//�½�session����
        teacherService.updateInfo(teacher);
        Teacher teacher1=teacherService.findBytnum(teacher.getTnum());
        session.setAttribute("teacher",teacher1);

        response.getWriter().write("<script>alert('update it already!');window.location='../pages/tinfo.jsp'; </script>");
        return null;



    }
    @RequestMapping(value = "/teacher/deletetask.action")
    @ResponseBody
    public String deletetaskAction(@RequestParam("id") Integer id , HttpServletResponse response) throws Exception{

        teacherService.deteletPubtaskById(id);
        response.getWriter().write("<script>alert('Delete it already!');window.location='tasklist'; </script>");
        return null;



    }


    @RequestMapping(value = "/teacher/tasklist")
    public ModelAndView taskList( HttpServletRequest request){
        /*  Teacher user=teacherService.findBytnum(tnum);*/
        HttpSession session = request.getSession(true);
        Teacher teacher= (Teacher) session.getAttribute("teacher");
        List<Pubtask> pubtaskList =teacherService.FindAllPubtaskByTnum(teacher.getTid());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pubtaskList",pubtaskList);
        modelAndView.setViewName("pubtask-list");
        return modelAndView;
    }

    @RequestMapping(value = "/teacher/uptasklist")
    public ModelAndView uptaskList( @RequestParam("id")Integer id){
        List<Uptask> uptaskList =teacherService.FindAlluptaskByPubid(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("uptasklist",uptaskList);
        modelAndView.setViewName("uptasklist");

        return modelAndView;
    }

 /*   @RequestMapping(value = "/teacher/uptasklist")
    public String uptaskList(@RequestParam("id")Integer id, Model model){
        //转发二
        List<Uptask> uptaskList =teacherService.FindAlluptaskByPubid(id);

        model.addAttribute("uptasklist",uptaskList);



        return "forward:/pages/uptasklist.jsp";
    }*/

    /*@Autowired
    private AccountService accountService;

    //保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }*/

}
