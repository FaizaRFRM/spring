package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {
    @Query(value = "SELECT s from Course s")
    List<Course> getAllCourses();
    @Query(value = "SELECT s from Course s where s.id= :courseId")
    Course getCourseById(@Param("courseId")Integer id);
}