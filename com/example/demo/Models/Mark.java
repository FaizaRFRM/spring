package com.example.demo.Models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    Integer obtaindMarks;
    String grade;
    @ManyToOne
    @JoinColumn(name="course_id",referencedColumnName = "id")
    Course course;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObtaindMarks() {
        return obtaindMarks;
    }

    public void setObtaindMarks(Integer obtaindMarks) {
        this.obtaindMarks = obtaindMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


}
