package edu.cuit.service.impl;

import edu.cuit.domain.Course;
import edu.cuit.mapper.CourseMapper;
import edu.cuit.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll(){
        return courseMapper.findAll();
    }

    @Override
    public void InsertCourse(Course course){
        courseMapper.InsertCourse(course);
    }

    @Override
    public void DeleteByCourseId(Integer courseid){
        courseMapper.DeleteByCourseid(courseid);
    }

    @Override
    public void UpdateCourse(Course course){
        courseMapper.UpdateCourse(course);
    }
}
