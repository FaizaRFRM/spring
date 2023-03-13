package com.example.demo.Controller;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import com.example.demo.RequestObject.CourseRequest;
import com.example.demo.RequestObject.MarketRequestForCreateDateUpdate;
import com.example.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    @RequestMapping(value = "findTopByOrderById", method = RequestMethod.GET)
    public Course findTopByOrderById() {
        Course course = courseService.findTopByOrderById();
        return course;
    }

    @RequestMapping(value = "FindBottomByOrderById", method = RequestMethod.GET)
    public Course FindBottomByOrderById() {
        Course course = courseService.FindBottomByOrderById();
        return course;
    }
    @RequestMapping(value = "getCourseCreatedAfterDate", method = RequestMethod.GET)
    public <List>Course getCourseCreatedAfterDate(@RequestParam String date) throws ParseException {
        Course course =courseService.getCourseCreatedAfterDate(date);
        return course;

    }
    @RequestMapping(value = "getCourseByCreatedDate", method = RequestMethod.GET)
    public <List>Course getCourseByCreatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.getCourseByCreatedDate(date);
        return course;

    }
    @RequestMapping(value = "getCourseByUpdatedDate", method = RequestMethod.GET)
    public <List>Course getCourseByUpdatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.getCourseByUpdatedDate(date);
        return course;

    }
    @RequestMapping(value = "deletCourseById", method = RequestMethod.POST)
    public void deletCourseById(@RequestParam Integer id) throws ParseException {
        courseService.deletCourseById(id);
    }
    @RequestMapping(value = "deletAllCourse", method = RequestMethod.POST)
    public void deletAllCourse() {
        courseService.deletAllCourse();
    }



    @RequestMapping(value = "deleteCourseByName", method = RequestMethod.POST)
    public Course deleteCourseByName(@RequestParam String CourseName) {
        Course course = courseService.deleteCourseByName(CourseName);
        return course;
    }
    @RequestMapping(value = "DeleteAllCoursesCreatedAfterDate", method = RequestMethod.GET)
    public <List> Course DeleteAllCoursesCreatedAfterDate(@RequestParam String date) throws ParseException {
        Course course = courseService.DeleteAllCoursesCreatedAfterDate(date);
        return course;

    }


    @RequestMapping(value = "DeleteCoursesByCreatedDate", method = RequestMethod.POST)
    public <List>Course DeleteCoursesByCreatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.DeleteCoursesByCreatedDate(date);
        return course;

    }
    @RequestMapping(value = "DeleteCoursesByUpdatedDate", method = RequestMethod.POST)
    public <List>Course DeleteCoursesByUpdatedDate(@RequestParam String date) throws ParseException {
        Course course =courseService.DeleteCoursesByUpdatedDate(date);
        return course;

    }
    @RequestMapping(value = "createCourse", method = RequestMethod.POST)
    public String createCourse() {
        courseService.createCourse();
        return "Course add successful";
    }

    @RequestMapping(value = "updateCourse")
    public void updateCourse(@RequestBody CourseRequest data)throws ParseException {
        courseService.updateCourse(data.getDate(),data.getId());
    }
}



//getCourseByStudentId
//getAllActiveCoursesForAStudent