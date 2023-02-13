package com.example.demo.Service;

import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//        public void addStudent() {
//            Student student = new Student();
//            student.setName("Faiza Thani");
//            student.setRollNumber("1");
//            studentRepository.save(student);
//
//        }

//        public void deleteStudentById(Integer id){
//            Student studentToDelete = studentRepository.findById(id).get();
//            studentRepository.delete(studentToDelete);
//        }
    }


