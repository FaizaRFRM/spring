package com.example.demo.Controller;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "course")

public class CourseController {
    @Autowired
    CourseService courseService;
    @RequestMapping(value = "course/getAll",method = RequestMethod.GET)
    public List<Course> getAllCourse() {
        List<Course> courses =new ArrayList<>();
        courses = courseService.getAllCourse();
        return courses;
    }
    @RequestMapping(value = "course/getById",method = RequestMethod.GET)

    public Course getCourseById (@RequestParam Integer id){
        Course course=courseService.getCourseById(id);
        return course;
    }

    @RequestMapping(value = "getAllCourseByIsActive", method = RequestMethod.GET)
    public List<Course> getAllCourseByIsActive(){
        List<Course>  activeCoursesList = courseService.getAllCourseByIsActive();
        return activeCoursesList;
    }
    @RequestMapping(value = "getAllCourseByInActive", method = RequestMethod.GET)
    public List<Course> getAllCourseByInActive(){
        List<Course>  InactiveCoursesList = courseService.getAllCourseByInActive();
        return InactiveCoursesList;
    }
}
