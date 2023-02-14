package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course extends BaseEntity{
    @Id
    Integer id;
    String name;
//
    @ManyToOne
    @JoinColumn(name="Student_id",referencedColumnName = "id")
    Student student;
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

}
