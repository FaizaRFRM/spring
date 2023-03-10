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
        Student getStudentById(@Param("studentId") Integer studentId);
        @Query(value = "SELECT s from Student s where s.IsActive = true")
        List<Student> getAllActiveStudents();
        @Query(value = "SELECT s from Student s where s.IsActive = false")
        List<Student> getAllInActiveStudents();
        @Query(value ="SELECT s from Student s where s.id=(SELECT max(s.id) from Student s)")
        Student findTopByOrderById();
        @Query(value ="SELECT s from Student s where s.updatedDate =(SELECT max(s.updatedDate) from Student s)")
        Student FindBottomByOrderById();
        @Query(value ="SELECT s from Student s where s.createdDate >= :date")
        <List>Student getStudentCreatedAfterDate(@Param("date") Date date);

        @Query(value = "SELECT s FROM Student s WHERE s.name= :studentName")
        Student getStudentBySchoolName(@Param("studentName") String studentName);
        @Query(value = "SELECT s From Student s WHERE s.rollNumber = :rollNumber")
        Student getByStudentByRollNumber(@Param("rollNumber") String rollNumber);
        @Query(value = "SELECT st from Student st"+
                " where st.school.id= :id")
        List <Student> getStudentsBySchoolId(@Param("id") Integer id);
        @Query(value ="SELECT s from Student s where s.createdDate = :date")
        <List>Student getStudentByCreatedDate(@Param("date") Date date);
        @Query(value ="SELECT s from Student s where s.updatedDate = :date")
        <List>Student getStudentByUpdatedDate(@Param("date") Date date);
        @Query(value = "Update  Student s set s.IsActive=false where s.id=:id")
        Student deletStudentById(@Param("id") Integer id);
        @Query(value = "Update Student s set s.IsActive = false")
        List<Student> deletAllStudent();

        @Query(value ="update Student s set s.IsActive=false where s.id >= :date")
        <List>Student DeleteAllStudentsCreatedAfterDate(@Param("date") Date date);
        @Query(value = "update Student s set s.IsActive=false where s.name= :studentName")
        Student deletStudentByName(@Param("studentName") String studentName);
        @Query(value = "update Student  s set s.IsActive=false where s.rollNumber= :rollNumber")
        Student setDeleteByStudentByRollNumber(@Param("rollNumber") String rollNumber);

        @Query(value = "update Student  s set s.isActive=false where s.id= :id")
        Student setDeleteStudentsBySchoolId(@Param("id") Integer id);
        @Query(value ="update Student s set s.IsActive=false where s.createdDate = :date")
        <List>Student DeleteStudentsByCreatedDate(@Param("date") Date date);
        @Query(value ="update Student s set s.IsActive=false where s.updatedDate = :date")
        <List>Student DeleteStudentsByUpdatedDate(@Param("date") Date date);

        @Query(value = "SELECT COUNT(id) From Student where id = ?1", nativeQuery = true)
        Integer getCountOfStudentsBySchoolId(Integer schoolId);

        @Query(value = "select DISTINCT school_id from Student ",nativeQuery = true)
        List<Integer> getUniqueSchoolIdsFromStudents();


}