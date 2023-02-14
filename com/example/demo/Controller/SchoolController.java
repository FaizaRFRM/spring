package com.example.demo.Controller;

import com.example.demo.Models.School;
import com.example.demo.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "school")

public class SchoolController {
//    @Autowired means  SchoolService schoolService=new SchoolService;
    @Autowired
    SchoolService schoolService;

    //    school Appi
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<School> getAllSchool(){
        List<School>schools=new ArrayList<>();
        schools=schoolService.getAllSchools();
        return schools;
    }
    @RequestMapping(value = "/getById",method = RequestMethod.GET)

    public School getSchoolById (@RequestParam Integer id){
        School school=schoolService.getSchoolById(id);
        return school;
    }

    @RequestMapping(value = "/getByName",method = RequestMethod.GET)

    public School getSchoolByName (@RequestParam String name){
        School school=schoolService.getSchoolByName(name);
        return school;
    }
    @RequestMapping(value = "getAllSchoolByIsActive", method = RequestMethod.GET)
    public List<School> getAllSchoolByIsActive(){
        List<School>  activeSchoolList = schoolService.getAllSchoolByIsActive();
        return activeSchoolList;
    }
    @RequestMapping(value = "getAllSchoolByInActive", method = RequestMethod.GET)
    public List<School> getAllSchoolByInActive(){
        List<School>  InactiveSchoolsList = schoolService.getAllSchoolByInActive();
        return InactiveSchoolsList;
    }


}
