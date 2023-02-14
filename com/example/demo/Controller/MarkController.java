package com.example.demo.Controller;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Service.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
