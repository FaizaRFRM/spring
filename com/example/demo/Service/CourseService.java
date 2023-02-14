package com.example.demo.Service;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    public List<Course> getAllCourse(){
        return courseRepository.getAllCourses();
    }
    public Course getCourseById(Integer id){
        Course course = courseRepository.getCourseById(id);
        return course;

    }
    public List<Course> getAllCourseByIsActive(){

        return courseRepository.getAllCourseByIsActive();
    }
    public List<Course> getAllCourseByInActive(){

        return courseRepository.getAllCourseByInActive();
    }

}
