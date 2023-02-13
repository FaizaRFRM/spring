package com.example.demo.Controller;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
//import com.example.demo.Service.CourceService;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.MarkService;
import com.example.demo.Service.SchoolService;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GeneralController {
    @Autowired
    StudentService studentService;
    @Autowired
    SchoolService schoolService;
    @Autowired
    CourseService courseService;
    @Autowired
    MarkService markService;
//    school Appi
    @RequestMapping(value = "school/getAll",method = RequestMethod.GET)
    public List<School> getAllSchool(){
        List<School>schools=new ArrayList<>();
        schools=schoolService.getAllSchools();
        return schools;
    }
    @RequestMapping(value = "school/getById",method = RequestMethod.GET)

    public School getSchoolById (@RequestParam Integer id){
        School school=schoolService.getSchoolById(id);
        return school;
    }
    @RequestMapping(value = "school/getByName",method = RequestMethod.GET)

    public School getSchoolByName (@RequestParam String name){
        School school=schoolService.getSchoolByName(name);
        return school;
    }
    @RequestMapping(value = "student/getAll",method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student>students=new ArrayList<>();
        students= studentService.getAllStudent();
        return students;
    }

    @RequestMapping(value = "student/getById",method = RequestMethod.GET)

    public Student getStudentById (@RequestParam Integer id){
        Student student=studentService.getStudentById(id);
        return student;
    }

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

    @RequestMapping(value = "Marks/getAll",method = RequestMethod.GET)
    public List<Mark> getAllMark() {
        List<Mark> marks =new ArrayList<>();
        marks = markService.getAllmarks();
        return marks;
    }

    @RequestMapping(value = "mark/getById",method = RequestMethod.GET)

    public Mark getMarkById (@RequestParam Integer id){
        Mark mark=markService.getMarkById(id);
        return mark;
    }

    @GetMapping(name="hello")

    public String HelloWord(){
        return "Hello words";
    }

}
