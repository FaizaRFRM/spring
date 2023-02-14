package com.example.demo.Repositories;


import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {


        @Query(value = "SELECT s from Student s")
        List<Student> getAllStudents();

        @Query(value = "SELECT s from Student s where s.id= :studentId")
        Student getStudentById(@Param("studentId") Integer id);

        @Query(value = "SELECT st from Student st"+
                " where st.school.id= :id")
        List <Student> getStudentBySchoolId(@Param("id") Integer id);

        @Query(value = "SELECT s from Student s where s.IsActive = true")
        List<Student> getAllActiveStudents();
        @Query(value = "SELECT s from Student s where s.IsActive = false")
        List<Student> getAllInActiveStudents();


}