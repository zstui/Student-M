package edu.cuit.service.impl;

import edu.cuit.domain.Pubtask;
import edu.cuit.domain.Student;
import edu.cuit.domain.Uptask;
import edu.cuit.mapper.PubtaskMapper;
import edu.cuit.mapper.StudentMapper;
import edu.cuit.mapper.TeacherMapper;
import edu.cuit.mapper.UptaskMapper;
import edu.cuit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("StudentService")
public class StudentServiceimpl implements StudentService {
    @Autowired
    private TeacherMapper teacherMapper;


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UptaskMapper uptaskMapper;

    @Autowired
    private PubtaskMapper pubtaskMapper;

    @Override
    public Student FindBynum(String snum){
        return studentMapper.findBySnum(snum);
    }

    @Override
    public List<Uptask> FindAllUptaskBycid(Integer cid){
        Student student=new Student();
        student.setCid(cid);
        return uptaskMapper.findAllByCid(student);
    }

    @Override
    public void UpdateUptask(Uptask uptask){
        uptaskMapper.update(uptask);
    }

    @Override
    public void InsertUptask(Uptask uptask){
        uptaskMapper.insert(uptask);
    }

    @Override
    public void DeleteUptask(Uptask uptask){
        uptaskMapper.delete(uptask);
    }

    @Override
    public void UpdateInfo(Student student){
        studentMapper.update(student);
    }

    @Override
    public List<Pubtask> FindAllPubtaskBycid(Integer cid){
        return pubtaskMapper.findAllBycid(cid);
    }

    @Override
    public Pubtask FindPubtaskByTitle(String title,Integer cid){
        return pubtaskMapper.FindByTitleAndCid(title,cid);
    }

    @Override
    public List<Student> findAll(){
        return  studentMapper.findAll();
    }

    @Override
    public void insertStudent(Student student){
        studentMapper.save(student);
    }

    @Override
    public void deleteBysnum(String snum){
        studentMapper.deleteBySnum(snum);
    }

    @Override
    public String submitUptask(CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String res = sdf.format(new Date());




        // uploads???????????????
        String rootPath =  "C://resource/uploads/";//request.getSession().getServletContext().getRealPath("resource/uploads/");
        // ????????????
        String originalFileName = file.getOriginalFilename();
        // ????????????
        String newFileName = "sliver" + res + originalFileName.substring(originalFileName.lastIndexOf("."));
        // ?????????????????????
        Calendar date = Calendar.getInstance();
        File dateDirs = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH)+1));

        // ?????????
        File newFile = new File(rootPath + File.separator + dateDirs + File.separator + newFileName);
        // ??????????????????????????????????????????
        if( !newFile.getParentFile().exists()) {
            // ???????????????????????????????????????????????????????????????
            newFile.getParentFile().mkdirs();
        }
        System.out.println(newFile);
        // ?????????????????????????????????
        file.transferTo(newFile);
        // ?????????url
        String fileUrl = date.get(Calendar.YEAR) + "/" + (date.get(Calendar.MONTH)+1) + "/" + newFileName;
        System.out.println(fileUrl);
        return  fileUrl;
        //???????????????
        //??????????????? : file.getOriginalFilename();
       /* String uploadFileName = file.getOriginalFilename();

        //?????????????????????????????????????????????
        if ("".equals(uploadFileName)){
            return "redirect:/index.jsp";
        }
        System.out.println("??????????????? : "+uploadFileName);

        //????????????????????????
        String path = request.getServletContext().getRealPath("/upload");
        String path2 = request.getContextPath();
        System.out.println(path2);
        //????????????????????????????????????
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        System.out.println("???????????????????????????"+realPath);

        InputStream is = file.getInputStream(); //???????????????
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //???????????????

        //????????????
        int len=0;
        byte[] buffer = new byte[1024];
        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }
        os.close();
        is.close();
        return "redirect:/index.jsp";*/




    }

    @Override
    public void submitUptaskAll(Uptask uptask) {
        uptaskMapper.insert(uptask);
    }

    @Override
    public Uptask submitUptaskinfo(Integer pubid, String title, String article, CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession(true);
        Student student= (Student) session.getAttribute("student");
        Pubtask pubtask = pubtaskMapper.findAllById(pubid);

        Uptask uptask =new Uptask();
        uptask.setSid(student.getSid());
        uptask.setTitle(title);
        uptask.setArticle(article);
        uptask.setTid(pubtask.getTid());
        uptask.setStatus("?????????");
        String attName=file.getOriginalFilename();
        String att= submitUptask(file,request);
        uptask.setAtt(att);
        uptask.setAttName(attName);

        uptask.setPubid(pubid);
        return  uptask;
    }

    @Override
    public List<Uptask> finduptaskBySid(Integer sid) {
        return uptaskMapper.findAllBySid(sid);
    }


}
