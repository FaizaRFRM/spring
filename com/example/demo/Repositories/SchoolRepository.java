package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolRepository extends CrudRepository<School,Integer> {
    @Query(value = "SELECT s from School s")
    List<School> getAllSchools ();
    @Query(value = "SELECT s from School s where s.id=:SchoolId")
   School getSchoolById(@Param("SchoolId")Integer id);
    @Query(value = "SELECT s from School s where s.name=:SchoolName")
    School getSchoolByName(@Param("SchoolName")String name);

}