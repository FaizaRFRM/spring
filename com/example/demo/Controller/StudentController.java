package com.example.demo.Controller;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.RequestObject.MarketRequestForCreateDateUpdate;
import com.example.demo.RequestObject.StudentRequest;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    @RequestMapping(value = "findTopByOrderById", method = RequestMethod.GET)
    public Student findTopByOrderById() {
        Student student = studentService.findTopByOrderById();
        return student;
    }

    @RequestMapping(value = "FindBottomByOrderById", method = RequestMethod.GET)
    public Student FindBottomByOrderById() {
        Student student = studentService.FindBottomByOrderById();
        return student;
    }
    @RequestMapping(value = "getStudentCreatedAfterDate", method = RequestMethod.GET)
    public <List>Student getStudentCreatedAfterDate(@RequestParam String date) throws ParseException {
        Student student =studentService.getStudentCreatedAfterDate(date);
        return student;

    }
    @RequestMapping(value = "getStudentByCreatedDate", method = RequestMethod.GET)
    public <List>Student getStudentByCreatedDate(@RequestParam String date) throws ParseException {
        Student student =studentService.getStudentByCreatedDate(date);
        return student;

    }
    @RequestMapping(value = "getStudentByUpdatedDate", method = RequestMethod.GET)
    public <List>Student getStudentByUpdatedDate(@RequestParam String date) throws ParseException {
        Student student =studentService.getStudentByUpdatedDate(date);
        return student;

    }
    @RequestMapping(value = "deletStudentById", method = RequestMethod.POST)
    public void deletStudentById(@RequestParam Integer id) throws ParseException {
        studentService.deletStudentById(id);
    }
    @RequestMapping(value = "deletAllStudent", method = RequestMethod.POST)
    public void deletAllStudent() {
        studentService.deletAllStudent();
    }



    @RequestMapping(value = "deletStudentByName", method = RequestMethod.POST)
    public Student deletStudentByName(@RequestParam String StudentName) {
        Student student = studentService.deletStudentByName(StudentName);
        return student;
    }
    @RequestMapping(value = "DeleteAllStudentsCreatedAfterDate", method = RequestMethod.GET)
    public <List> Student DeleteAllStudentsCreatedAfterDate(@RequestParam String date) throws ParseException {
        Student student = studentService.DeleteAllStudentsCreatedAfterDate(date);
        return student;

    }

    @RequestMapping(value = "DeleteStudentsByCreatedDate", method = RequestMethod.POST)
    public <List>Student DeleteStudentsByCreatedDate(@RequestParam String date) throws ParseException {
        Student student =studentService.DeleteStudentsByCreatedDate(date);
        return student;

    }
    @RequestMapping(value = "DeleteStudentsByUpdatedDate", method = RequestMethod.POST)
    public <List>Student DeleteStudentsByUpdatedDate(@RequestParam String date) throws ParseException {
        Student student =studentService.DeleteStudentsByUpdatedDate(date);
        return student;

    }
    @RequestMapping(value = "setDeleteByStudentByRollNumber",method = RequestMethod.POST)
    public <List>Student setDeleteByStudentByRollNumber(@RequestParam String rollNumber) throws ParseException{
        Student student =studentService.setDeleteByStudentByRollNumber(rollNumber);
        return student;
    }

    @RequestMapping(value = "getByStudentByRollNumber",method=RequestMethod.GET)
    public <List>Student getByStudentByRollNumber(@RequestParam String rollNumber) throws ParseException{
        Student student=studentService.getByStudentByRollNumber(rollNumber);
        return student;
    }
    @RequestMapping(value = "createStudent", method = RequestMethod.POST)
    public String createStudent() {
        studentService.createStudent();
        return "Student add successful";
    }

    @RequestMapping(value = "updateStudent")
    public void updateStudent(@RequestBody StudentRequest data)throws ParseException {
        studentService.updateStudent(data.getDate(),data.getId());
    }


}


//getStudentsBySchoolId
//deleteStudentsBySchoolId