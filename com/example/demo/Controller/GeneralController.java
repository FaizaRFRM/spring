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
//    @Autowired
//    StudentService studentService;
//    @Autowired
//    SchoolService schoolService;
//    @Autowired
//    CourseService courseService;
//    @Autowired
//    MarkService markService;

    @GetMapping(name="hello")

    public String HelloWord(){
        return "Hello words";
    }

}
