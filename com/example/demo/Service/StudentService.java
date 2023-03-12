package com.example.demo.Service;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {


        @Autowired
        StudentRepository studentRepository;

         @Autowired
         SchoolRepository schoolRepository;
    public List<Student> getAllStudent(){
        return studentRepository.getAllStudents();
    }

    public Student getStudentById(Integer id) {
        Student student = studentRepository.getStudentById(id);
        return student;
    }


    public List<Student> getStudentBySchoolName(String schoolName){
        School school = schoolRepository.getSchoolByName(schoolName);
        Integer schoolId = school.getId();
        List<Student> studentList = studentRepository.getStudentBySchoolId(schoolId);
        return studentList;
    }

    public List<Student> getAllActiveStudents(){

        return studentRepository.getAllActiveStudents();
    }
    public List<Student> getAllInActiveStudents(){

        return studentRepository.getAllInActiveStudents();
    }

    public Student findTopByOrderById() {
        Student student = studentRepository.findTopByOrderById();
        return student;

    }

    public Student FindBottomByOrderById() {
        Student student = studentRepository.FindBottomByOrderById();
        return student;

    }

    public <List> Student getStudentCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(date);
        return studentRepository.getStudentCreatedAfterDate(date1);


    }

    public <List> Student getStudentByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return studentRepository.getStudentByCreatedDate(CreateDate);


    }

    public <List> Student getStudentByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return studentRepository.getStudentByUpdatedDate(UpdateDate);


    }

    public void deletStudentById(Integer id) throws ParseException {
        Student student = studentRepository.deletStudentById(id);
        student.setActive(true);
        studentRepository.save(student);
    }

    public void deletAllStudent() {
        Student student = (Student) studentRepository.deletAllStudent();
        student.setActive(true);
        studentRepository.save(student);
    }

    public <List> Student DeleteAllStudentsCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date Date1 = formatter.parse(date);
        return studentRepository.DeleteAllStudentsCreatedAfterDate(Date1);
    }

    public Student deletStudentByName(String studentName) {
        Student student = studentRepository.deletStudentByName(studentName);
        return student;
    }

    public <List> Student DeleteStudentsByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return studentRepository.DeleteStudentsByCreatedDate(CreateDate);

    }

    public <List> Student DeleteStudentsByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return studentRepository.DeleteStudentsByUpdatedDate(UpdateDate);


    }
    public <List>Student setDeleteByStudentByRollNumber(String rollNumber)throws ParseException{
        return studentRepository.setDeleteByStudentByRollNumber(rollNumber) ;
    }
    public<List> Student getByStudentByRollNumber(String rollNumber)throws ParseException{
        return studentRepository.getByStudentByRollNumber(rollNumber);

    }
    public void createStudent() {
        Student student = new Student();
        student.setName("ABC Student");
        studentRepository.save(student);
    }
    public void updateStudent(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Student student = studentRepository.getStudentById(id);
        student.setCreatedDate(javaDate);
        student.setName("ABC Student");
        studentRepository.save(student);

    }
    }


