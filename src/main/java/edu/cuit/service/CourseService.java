package edu.cuit.service;

import edu.cuit.domain.Course;

import java.util.List;

public interface CourseService {
    public List<Course> findAll();

    public void InsertCourse(Course course);

    public void DeleteByCourseId(Integer courseid);

    public void UpdateCourse(Course course);
}
