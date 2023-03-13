package com.example.demo.Service;

import com.example.demo.Models.Course;
import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Repositories.MarkRepository;
import com.example.demo.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public Mark findTopByOrderById() {
        Mark mark = markRepository.findTopByOrderById();
        return mark;

    }

    public Mark FindBottomByOrderById() {
        Mark mark = markRepository.FindBottomByOrderById();
        return mark;

    }

    public <List> Mark getMarkCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = formatter.parse(date);
        return markRepository.getMarkCreatedAfterDate(date1);


    }

    public <List> Mark getMarkByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return markRepository.getMarkByCreatedDate(CreateDate);


    }

    public <List> Mark getMarkByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return markRepository.getMarkByUpdatedDate(UpdateDate);


    }

    public void deletMarkById(Integer id) throws ParseException {
        Mark mark = markRepository.deletMarkById(id);
        mark.setActive(true);
        markRepository.save(mark);
    }

    public void deletAllMark() {
        Mark mark = markRepository.deletAllMark();
        mark.setActive(true);
        markRepository.save(mark);
    }

    public <List> Mark DeleteAllMarksCreatedAfterDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date Date1 = formatter.parse(date);
        return markRepository.DeleteAllMarksCreatedAfterDate(Date1);
    }

    public <List> Mark DeleteMarksByCreatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date CreateDate = formatter.parse(date);
        return markRepository.DeleteMarksByCreatedDate(CreateDate);


    }


    public <List> Mark DeleteMarksByUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date UpdateDate = formatter.parse(date);
        return markRepository.DeleteMarksByUpdatedDate(UpdateDate);


    }
    public void createMark() {
        Mark mark = new Mark();
        mark.setObtaindMarks(123);
        markRepository.save(mark);
    }
    public void updateMark(String date, Integer id) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");
        Date javaDate = formatter.parse(date);
        Mark mark = markRepository.getMarkById(id);
        mark.setCreatedDate(javaDate);
        mark.setObtaindMarks(123);
        markRepository.save(mark);

    }
    public Mark getMarkByGrade(Integer grade) {
        Mark mark = markRepository.getMarkByGrade(grade);
        return mark;
    }
}
