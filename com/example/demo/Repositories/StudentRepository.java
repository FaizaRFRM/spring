package com.example.demo.Repositories;


import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
        @Query(value ="SELECT s from Student s where s.id=(SELECT max(s.id) from Student s)")
        Student findTopByOrderById();
        @Query(value ="SELECT s from Student s where s.updateDate =(SELECT max(s.updateDate) from Student s)")
        Student FindBottomByOrderById();
        @Query(value ="SELECT s from Student s where s.createDate >= :date")
        <List>Student getStudentCreatedAfterDate(@Param("date") Date date);
        @Query(value ="SELECT s from Student s where s.createDate = :date")
        <List>Student getStudentByCreatedDate(@Param("date") Date date);
        @Query(value ="SELECT s from Student s where s.updateDate = :date")
        <List>Student getStudentByUpdatedDate(@Param("date") Date date);
        @Query(value = "Update  Student s set s.isActive=false where s.id=:id")
        Student deletStudentById(@Param("id") Integer id);
        @Query(value = "Update Student s set s.IsActive = false")
        List<Student> deletAllStudent();
        @Query(value = "update Student s set s.isActive=false where s.name= :studentName")
        Student deletStudentByName(@Param("studentName") String name);
        @Query(value ="update Student s set s.isActive=false where s.id >= :date")
        <List>Student DeleteAllStudentsCreatedAfterDate(@Param("date") Date date);

        @Query(value ="update Student s from Student s where s.createDate = :date")
        <List>Student DeleteStudentsByCreatedDate(@Param("date") Date date);
        @Query(value ="update Student s from Student s where s.createDate = :date")
        <List>Student DeleteStudentsByUpdatedDate(@Param("date") Date date);
        @Query(value = "SELECT DISTINCT school_id FROM student", nativeQuery = true)
        List<Integer> getDistinctSchoolIdsFromStudent();


        @Query(value = "SELECT COUNT(id) From student where school_id = :?1", nativeQuery = true)
        Integer getCountOfStudentsBySchoolId(Integer schoolId);

}