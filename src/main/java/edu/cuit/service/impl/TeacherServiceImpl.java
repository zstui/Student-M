package edu.cuit.service.impl;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Teacher;
import edu.cuit.domain.Uptask;
import edu.cuit.mapper.PubtaskMapper;
import edu.cuit.mapper.TeacherMapper;
import edu.cuit.mapper.UptaskMapper;
import edu.cuit.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private PubtaskMapper pubtaskMapper;

    @Autowired
    private UptaskMapper uptaskMapper;
    @Override
    public Teacher findBytnum(String tnum) {

        return teacherMapper.findBytnum(tnum);
    }

    @Override
    public void updatePubtask(Pubtask pubtask) {
        pubtaskMapper.update(pubtask);
    }

    @Override
    public Pubtask findPubtaskById(Integer id) {
        return pubtaskMapper.findAllById(id);
    }

    @Override
    public void insertPubtask(Pubtask pubtask) {
        pubtaskMapper.insert(pubtask);

    }

    @Override
    public List<Pubtask> FindAllPubtask() {
        return pubtaskMapper.findAll();
    }

    @Override
    public List<Pubtask> FindAllPubtaskByTnum(Integer tid) {
        return pubtaskMapper.findAllByTid(tid);
    }

    @Override
    public void deteletPubtaskById(Integer id) {
        pubtaskMapper.delete(id);
    }

    @Override
    public List<Uptask> FindAlluptaskByPubid(Integer id) {
        return uptaskMapper.findAllByPubid(id);
    }

    @Override
    public void updateInfo(Teacher teacher) {
        teacherMapper.update(teacher);
    }

    @Override
    public void updateUptask(Uptask uptask) {
        uptaskMapper.update(uptask);
    }

    @Override
    public Integer updateGrade(Integer grade,Integer aid) {
        uptaskMapper.updateGrade(grade,aid);
        return uptaskMapper.findAllByAid(aid);
    }

    @Override
    public Uptask findUptask(Integer aid) {
        return uptaskMapper.findByaid(aid);
    }

    @Override
    public List<Teacher> findAll(){
        return teacherMapper.findAll();
    }

    @Override
    public void insertTeacher(Teacher teacher){
        teacherMapper.save(teacher);
    }

    public void deleteByTnum(String tnum){
        teacherMapper.deleteByTnum(tnum);
    }


    @Override
    public void downlaodFile(Integer aid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Uptask uptask =uptaskMapper.findByaid(aid);

        //????????????????????????
        String  path = "C:/resource/uploads/"+uptask.getAtt();
        String  fileName = uptask.getAttName();
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            response.setContentType("text/html; charset=UTF-8");//??????text/html??????application/html
            response.getWriter().print("<html><body><script type='text/javascript'>alert('????????????????????????????????????');window.history.back();</script></body></html>");
            response.getWriter().close();
            System.out.println("???????????????????????????????????????");
            return;
        }

        //1?????????response ?????????
        response.reset(); //?????????????????????,??????buffer
        fileName = URLEncoder.encode(fileName,"UTF-8");
        response.setCharacterEncoding("UTF-8"); //????????????
        response.setContentType("multipart/form-data"); //?????????????????????
        //???????????????
        response.addHeader("Content-Disposition",
                "attachment;fileName="+ fileName);


        //2??? ????????????--?????????
        InputStream input=new FileInputStream(file);
        //3??? ????????????--?????????
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4????????? ????????????
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();

    }
}
