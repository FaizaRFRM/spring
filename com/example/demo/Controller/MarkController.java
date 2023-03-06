package com.example.demo.Controller;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.RequestObject.MarkRequest;
import com.example.demo.RequestObject.MarketRequestForCreateDateUpdate;
import com.example.demo.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "mark")

public class MarkController {
    @Autowired
    MarkService markService;
    @RequestMapping(value = "Marks/getAll",method = RequestMethod.GET)
    public List<Mark> getAllMark() {
        List<Mark> marks =new ArrayList<>();
        marks = markService.getAllmarks();
        return marks;
    }

    @RequestMapping(value = "mark/getById",method = RequestMethod.GET)

    public Mark getMarkById (@RequestParam Integer id){
        Mark mark=markService.getMarkById(id);
        return mark;
    }

    @RequestMapping(value = "getAllMarkByIsActive", method = RequestMethod.GET)
    public List<Mark> getAllMarkByIsActive(){
        List<Mark>  activeMarksList = markService.getAllMarkByIsActive();
        return activeMarksList;
    }
    @RequestMapping(value = "getAllInActiveMarks", method = RequestMethod.GET)
    public List<Mark> getAllInActiveMarks(){
        List<Mark>  InactiveMarksList = markService.getAllInActiveMarks();
        return InactiveMarksList;

    }
    @RequestMapping(value = "findTopByOrderById", method = RequestMethod.GET)
    public Mark findTopByOrderById() {
        Mark mark = markService.findTopByOrderById();
        return mark;
    }

    @RequestMapping(value = "FindBottomByOrderById", method = RequestMethod.GET)
    public Mark FindBottomByOrderById() {
        Mark mark = markService.FindBottomByOrderById();
        return mark;
    }
    @RequestMapping(value = "getMarkCreatedAfterDate", method = RequestMethod.GET)
    public <List>Mark getMarkCreatedAfterDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.getMarkCreatedAfterDate(date);
        return mark;

    }
//    @RequestMapping(value = "getMarkByCreatedDate", method = RequestMethod.GET)
//    public <List>Mark getMarkByCreatedDate(@RequestParam String date) throws ParseException {
//        Mark mark =markService.getMarkByCreatedDate(date);
//        return mark;
//
//    }
    @RequestMapping(value = "getMarkByUpdatedDate", method = RequestMethod.GET)
    public <List>Mark getMarkByUpdatedDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.getMarkByUpdatedDate(date);
        return mark;

    }
    @RequestMapping(value = "deletMarkById", method = RequestMethod.POST)
    public void deletMarkById(@RequestParam Integer id) throws ParseException {
        markService.deletMarkById(id);
    }
    @RequestMapping(value = "deletAllMark", method = RequestMethod.POST)
    public void deletAllMark() {
        markService.deletAllMark();
    }
    @RequestMapping(value = "DeleteAllMarksCreatedAfterDate", method = RequestMethod.GET)
    public <List> Mark DeleteAllMarksCreatedAfterDate(@RequestParam String date) throws ParseException {
        Mark mark = markService.DeleteAllMarksCreatedAfterDate(date);
        return mark;

    }

    @RequestMapping(value = "DeleteMarksByCreatedDate", method = RequestMethod.POST)
    public <List>Mark DeleteMarksByCreatedDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.DeleteMarksByCreatedDate(date);
        return mark;

    }
    @RequestMapping(value = "DeleteMarksByUpdatedDate", method = RequestMethod.POST)
    public <List>Mark DeleteMarksByUpdatedDate(@RequestParam String date) throws ParseException {
        Mark mark =markService.DeleteMarksByUpdatedDate(date);
        return mark;

    }
}

//getAllByGrade
//getByObtainedMarksMoreThan
//getByObtainedMarksLessThan
//getMarksByCourseId
//deleteMarksByCourseId

//createMarks
//updateMarks