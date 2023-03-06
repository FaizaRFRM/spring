package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Date;
@Repository
public interface SchoolRepository extends CrudRepository<School,Integer> {
    @Query(value = "SELECT s from School s")
    List<School> getAllSchools();

    @Query(value = "SELECT s from School s where s.id=:SchoolId")
    School getSchoolById(@Param("SchoolId") Integer id);

    @Query(value = "SELECT s from School s where s.name=:SchoolName")
    School getSchoolByName(@Param("SchoolName") String name);


    @Query(value = "SELECT s from School s where s.IsActive = true")
    List<School> getAllSchoolByIsActive();
    @Query(value = "SELECT s from School s where s.IsActive = false")
    List<School> getAllSchoolByInActive();

    @Query(value ="SELECT s from School s where s.id=(SELECT max(s.id) from School s)")
    School findTopByOrderById();
    @Query(value ="SELECT s from School s where s.updateDate =(SELECT max(s.updateDate) from School s)")
    School FindBottomByOrderById();
    @Query(value ="SELECT s from School s where s.createDate >= :date")
    <List>School getSchoolCreatedAfterDate(@Param("date") Date date);
    @Query(value ="SELECT s from School s where s.createDate = :date")
    <List>School getSchoolByCreatedDate(@Param("date") Date date);
    @Query(value ="SELECT s from School s where s.updateDate = :date")
    <List>School getSchoolByUpdatedDate(@Param("date") Date date);
    @Query(value = "Update  School s set s.isActive=false where s.id=:id")
    School deletSchoolById(@Param("id") Integer id);
    @Query(value = "Update School s set s.IsActive = false")

    List<School> deletAllSchool();
    @Query(value = "update School  s set s.isActive=false where s.name= :schoolName")
    School deletSchoolByName(@Param("SchoolName") String name);
    @Query(value ="update School s set s.isActive=false where s.id >= :date")
    <List>School DeleteAllSchoolsCreatedAfterDate(@Param("date") Date date);

    @Query(value ="update School s from School s where s.createDate = :date")
    <List>School DeleteSchoolsByCreatedDate(@Param("date") Date date);
    @Query(value ="update School s from School s where s.createDate = :date")
    <List>School DeleteSchoolsByUpdatedDate(@Param("date") Date date);




}
