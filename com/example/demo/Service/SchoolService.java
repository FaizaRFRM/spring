package com.example.demo.Service;
//import com.coding.codeline.course.Repositories.StudentRepository;

import com.example.demo.Models.School;
import com.example.demo.Repositories.SchoolRepository;
import com.example.demo.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;

import java.util.ArrayList;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    StudentRepository studentRepository;

    public List<School> getAllSchools() {
        return schoolRepository.getAllSchools();
    }

    public School getSchoolById(Integer id) {
        School school = schoolRepository.getSchoolById(id);
        return school;
    }

    public School getSchoolByName(String name) {
        School school = schoolRepository.getSchoolByName(name);
        return school;
    }

    public List<School> getAllSchoolByIsActive() {

        return schoolRepository.getAllSchoolByIsActive();
    }

    public List<School> getAllSchoolByInActive() {

        return schoolRepository.getAllSchoolByInActive();
    }

    public School findTopByOrderById() {
        School school = schoolRepository.findTopByOrderById();
        return school;

    }

    public School FindBottomByOrderById() {
        School school = schoolRepository.FindBottomByOrderById();
        return school;

    }

    public <List> School getSchoolCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(date);
        return schoolRepository.getSchoolCreatedAfterDate(date1);


    }

    public <List> School getSchoolByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return schoolRepository.getSchoolByCreatedDate(CreateDate);


    }

    public <List> School getSchoolByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return schoolRepository.getSchoolByUpdatedDate(UpdateDate);


    }

    public void deletSchoolById(Integer id) throws ParseException {
        School school = schoolRepository.deletSchoolById(id);
        school.setActive(true);
        schoolRepository.save(school);
    }

    public void deletAllSchool() {
        School school = (School) schoolRepository.deletAllSchool();
        school.setActive(true);
        schoolRepository.save(school);
    }

    public <List> School DeleteAllSchoolsCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date Date1 = formatter.parse(date);
        return schoolRepository.DeleteAllSchoolsCreatedAfterDate(Date1);
    }

    public School deletSchoolByName(String schoolName) {
        School school = schoolRepository.deletSchoolByName(schoolName);
        return school;
    }

    public <List> School DeleteSchoolsByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return schoolRepository.DeleteSchoolsByCreatedDate(CreateDate);


    }

    public <List> School DeleteSchoolsByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return schoolRepository.DeleteSchoolsByUpdatedDate(UpdateDate);

    }
    public List<School> getSchoolByNumberOfStudents(Integer numberOfStudents){
        List<Integer> schoolIds = studentRepository.getUniqueSchoolIdsFromStudents();
        HashMap<Integer, Integer> idCountMap = new HashMap<>();
        List<School> listOfSchoolByNumberOfStudent = new ArrayList<>();

        for (Integer id: schoolIds) {
            idCountMap.put(id, studentRepository.getCountOfStudentsBySchoolId(id));
        }

        for (Integer id: idCountMap.keySet()) {
            if(idCountMap.get(id) == numberOfStudents){
                listOfSchoolByNumberOfStudent.add(schoolRepository.getSchoolById(id));
            }
        }

        return listOfSchoolByNumberOfStudent;

    }
    public void createSchool() {
        School school = new School();
        school.setName("ABC School");
        schoolRepository.save(school);
    }
    public void updateSchool(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        School school = schoolRepository.getSchoolById(id);
        school.setCreatedDate(javaDate);
        school.setName("ABC School");
        schoolRepository.save(school);

    }

}
