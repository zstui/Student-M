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
    public void downlaodFile(Integer aid, HttpServletRequest request, HttpServletResponse response) throws IOException {
       Uptask uptask =uptaskMapper.findByaid(aid);

        //要下载的图片地址
        String  path = "C:/resource/uploads/"+uptask.getAtt();
        String  fileName = uptask.getAttName();
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
            response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');window.history.back();</script></body></html>");
            response.getWriter().close();
            System.out.println("您要下载的资源已被删除！！");
            return;
        }

        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        fileName = URLEncoder.encode(fileName,"UTF-8");
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.addHeader("Content-Disposition",
                "attachment;fileName="+ fileName);


        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();

    }


}
