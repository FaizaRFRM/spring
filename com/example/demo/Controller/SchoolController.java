package com.example.demo.Controller;

import com.example.demo.Models.School;
import com.example.demo.RequestObject.MarketRequestForCreateDateUpdate;
import com.example.demo.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "school")

public class SchoolController {
    //    @Autowired means  SchoolService schoolService=new SchoolService;
    @Autowired
    SchoolService schoolService;

    //    school Appi
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<School> getAllSchool() {
        List<School> schools = new ArrayList<>();
        schools = schoolService.getAllSchools();
        return schools;
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)

    public School getSchoolById(@RequestParam Integer id) {
        School school = schoolService.getSchoolById(id);
        return school;
    }


    @RequestMapping(value = "/getByName", method = RequestMethod.GET)

    public School getSchoolByName(@RequestParam String name) {
        School school = schoolService.getSchoolByName(name);
        return school;
    }

    @RequestMapping(value = "getAllSchoolByIsActive", method = RequestMethod.GET)
    public List<School> getAllSchoolByIsActive() {
        List<School> activeSchoolList = schoolService.getAllSchoolByIsActive();
        return activeSchoolList;
    }

    @RequestMapping(value = "getAllSchoolByInActive", method = RequestMethod.GET)
    public List<School> getAllSchoolByInActive() {
        List<School> InactiveSchoolsList = schoolService.getAllSchoolByInActive();
        return InactiveSchoolsList;

    }

    @RequestMapping(value = "findTopByOrderById", method = RequestMethod.GET)
    public School findTopByOrderById() {
        School school = schoolService.findTopByOrderById();
        return school;
    }

    @RequestMapping(value = "FindBottomByOrderById", method = RequestMethod.GET)
    public School FindBottomByOrderById() {
        School school = schoolService.FindBottomByOrderById();
        return school;
    }
    @RequestMapping(value = "getSchoolCreatedAfterDate", method = RequestMethod.GET)
    public <List>School getSchoolCreatedAfterDate(@RequestParam String date) throws ParseException {
        School school =schoolService.getSchoolCreatedAfterDate(date);
        return school;

    }
    @RequestMapping(value = "getSchoolByCreatedDate", method = RequestMethod.GET)
    public <List>School getSchoolByCreatedDate(@RequestParam String date) throws ParseException {
        School school =schoolService.getSchoolByCreatedDate(date);
        return school;

    }
    @RequestMapping(value = "getSchoolByUpdatedDate", method = RequestMethod.GET)
    public <List>School getSchoolByUpdatedDate(@RequestParam String date) throws ParseException {
        School school =schoolService.getSchoolByUpdatedDate(date);
        return school;

    }
    @RequestMapping(value = "deletSchoolById", method = RequestMethod.POST)
    public void deletSchoolById(@RequestParam Integer id) throws ParseException {
        schoolService.deletSchoolById(id);
    }
    @RequestMapping(value = "deletAllSchool", method = RequestMethod.POST)
    public void deletAllSchool() {
        schoolService.deletAllSchool();
    }



    @RequestMapping(value = "deletSchoolByName", method = RequestMethod.POST)
    public School deletSchoolByName(@RequestParam String SchoolName) {
        School school = schoolService.deletSchoolByName(SchoolName);
        return school;
    }
    @RequestMapping(value = "DeleteAllSchoolsCreatedAfterDate", method = RequestMethod.GET)
    public <List> School DeleteAllSchoolsCreatedAfterDate(@RequestParam String date) throws ParseException {
        School school = schoolService.DeleteAllSchoolsCreatedAfterDate(date);
        return school;

    }

    @RequestMapping(value = "DeleteSchoolsByCreatedDate", method = RequestMethod.POST)
    public <List>School DeleteSchoolsByCreatedDate(@RequestParam String date) throws ParseException {
        School school =schoolService.DeleteSchoolsByCreatedDate(date);
        return school;

    }
    @RequestMapping(value = "DeleteSchoolsByUpdatedDate", method = RequestMethod.POST)
    public <List>School DeleteSchoolsByUpdatedDate(@RequestParam String date) throws ParseException {
        School school =schoolService.DeleteSchoolsByUpdatedDate(date);
        return school;

    }
    @RequestMapping(value = "getSchoolByNumberOfStudent", method = RequestMethod.POST)
    public List<School> getSchoolByNumberOfStudent(@RequestParam Integer numberOfStudent) {
        List<School> schoolList = new ArrayList<>();
        return schoolList;
    }


}


//getSchoolByNumberOfStudents
//createSchool
//updateSchool