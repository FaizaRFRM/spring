package com.example.demo.Service;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.Repositories.CourseRepository;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Course findTopByOrderById() {
        Course course = courseRepository.findTopByOrderById();
        return course;

    }

    public Course FindBottomByOrderById() {
        Course course = courseRepository.FindBottomByOrderById();
        return course;

    }

    public <List> Course getCourseCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(date);
        return courseRepository.getCourseCreatedAfterDate(date1);


    }

    public <List> Course getCourseByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return courseRepository.getCourseByCreatedDate(CreateDate);


    }

    public <List> Course getCourseByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return courseRepository.getCourseByUpdatedDate(UpdateDate);


    }

    public void deletCourseById(Integer id) throws ParseException {
        Course course = courseRepository.deletCourseById(id);
        course.setActive(true);
        courseRepository.save(course);
    }

    public void deletAllCourse() {
        Course course = (Course) courseRepository.deletAllCourse();
        course.setActive(true);
        courseRepository.save(course);
    }

    public <List> Course DeleteAllCoursesCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date Date1 = formatter.parse(date);
        return courseRepository.DeleteAllCoursesCreatedAfterDate(Date1);
    }

    public Course deletCourseByName(String courseName) {
        Course course = courseRepository.deletCourseByName(courseName);
        return course;
    }

    public <List> Course DeleteCoursesByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return courseRepository.DeleteCoursesByCreatedDate(CreateDate);


    }


    public <List> Course DeleteCoursesByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return courseRepository.DeleteCoursesByUpdatedDate(UpdateDate);


    }

}
