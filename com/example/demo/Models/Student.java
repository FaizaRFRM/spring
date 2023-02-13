package com.example.demo.Models;

import javax.persistence.*;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    String name;
    String rollNumber;

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    //    @OneToMany
//    @JoinColumn(referencedColumnName = "id")
//    List<Course>cource;
    @ManyToOne
    @JoinColumn(name="School_id",referencedColumnName = "id")
    School school;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
}