package com.example.demo.Controller;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "student")

public class StudentController {
    @Autowired
    StudentService studentService;
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
    @RequestMapping(value = "student/getStudentBySchoolName", method = RequestMethod.GET)
    public List<Student> getStudentBySchoolName(@RequestParam String schoolName) {

        return studentService.getStudentBySchoolName(schoolName);
    }
    @RequestMapping(value = "getAllActiveStudents", method = RequestMethod.GET)
    public List<Student> getAllActiveStudents(){
        List<Student>  activeStudentsList = studentService.getAllActiveStudents();
        return activeStudentsList;
    }
    @RequestMapping(value = "getAllInActiveStudents", method = RequestMethod.GET)
    public List<Student> getAllInActiveStudents(){
        List<Student>  InactiveStudentsList = studentService.getAllInActiveStudents();
        return InactiveStudentsList;
    }
}
