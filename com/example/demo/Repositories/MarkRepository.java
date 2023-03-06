package com.example.demo.Repositories;

import com.example.demo.Models.Mark;
import com.example.demo.Models.School;
import com.example.demo.Models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark,Integer> {
    @Query(value = "SELECT s from Mark s")
    List<Mark> getAllMarks ();
    @Query(value = "SELECT s from Mark s where s.id= :markId")
    Mark getMarkById(@Param("markId")Integer id);
    @Query(value = "SELECT s from Mark s where s.IsActive = true")
    List<Mark> getAllMarkByIsActive();
    @Query(value = "SELECT s from Mark s where s.IsActive = false")
    List<Mark> getAllInActiveMarks();
    @Query(value ="SELECT s from Mark s where s.id=(SELECT max(s.id) from Mark s)")
    Mark findTopByOrderById();
    @Query(value ="SELECT s from Mark s where s.updateDate =(SELECT max(s.updateDate) from Mark s)")
    Mark FindBottomByOrderById();
    @Query(value ="SELECT s from Mark s where s.createDate >= :date")
    <List>Mark getMarkCreatedAfterDate(@Param("date") Date date);
    @Query(value ="SELECT s from Mark s where s.createDate = :date")
    <List>Mark getMarkByCreatedDate(@Param("date") Date date);
    @Query(value ="SELECT s from Mark s where s.updateDate = :date")
    <List>Mark getMarkByUpdatedDate(@Param("date") Date date);
    @Query(value = "Update  Mark s set s.isActive=false where s.id=:id")

    Mark deletMarkById(@Param("id") Integer id);
    @Query(value = "Update Mark s set s.IsActive = false")
    List<Mark> deletAllMark();
    @Query(value ="update Mark s set s.isActive=false where s.id >= :date")
    <List>Mark DeleteAllMarksCreatedAfterDate(@Param("date") Date date);

    @Query(value ="update Mark s from Mark s where s.createDate = :date")
    <List>Mark DeleteMarksByCreatedDate(@Param("date") Date date);
    @Query(value ="update School s from Mark s where s.createDate = :date")
    <List>Mark DeleteMarksByUpdatedDate(@Param("date") Date date);
}
