package com.example.demo.Service;

import com.example.demo.Models.School;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;
    public List<School>getAllSchools(){
        return schoolRepository.getAllSchools();
    }
    public School getSchoolById(Integer id){
        School school = schoolRepository.getSchoolById(id);
        return school;
    }
    public School getSchoolByName(String name){
        School school = schoolRepository.getSchoolByName(name);
        return school;
    }
    public List<School> getAllSchoolByIsActive(){

        return schoolRepository.getAllSchoolByIsActive();
    }
    public List<School> getAllSchoolByInActive(){

        return schoolRepository.getAllSchoolByInActive();
    }

}
