package com.example.demo.Models;

import javax.persistence.*;
import java.util.List;
@Entity
public class School  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="school_name")
    String name;
//    @OneToMany
//    @JoinColumn(referencedColumnName = "id")
//    List<Student> students;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public List<Student> getStudents() {
//        return students;
//    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

}
