package com.example.demo.Service;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Repositories.MarkRepository;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {
    @Autowired
    MarkRepository markRepository;


    public List<Mark> getAllmarks(){
        return markRepository.getAllMarks();
    }
    public Mark getMarkById(Integer id){
        Mark mark = markRepository.getMarkById(id);
        return mark;
    }
    public List<Mark> getAllMarkByIsActive(){

        return markRepository.getAllMarkByIsActive();
    }
    public List<Mark> getAllInActiveMarks(){

        return markRepository.getAllInActiveMarks();
    }
}
