package com.example.demo.Repositories;

import com.example.demo.Models.Course;
import com.example.demo.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course,Integer> {
    @Query(value = "SELECT s from Course s")
    List<Course> getAllCourses();
    @Query(value = "SELECT s from Course s where s.id= :courseId")
    Course getCourseById(@Param("courseId")Integer id);
    @Query(value = "SELECT s from Course s where s.IsActive = true")
    List<Course> getAllCourseByIsActive();
    @Query(value = "SELECT s from Course s where s.IsActive = false")
    List<Course> getAllCourseByInActive();
    @Query(value ="SELECT s from Course s where s.id=(SELECT max(s.id) from Course s)")
    Course findTopByOrderById();
    @Query(value ="SELECT s from Course s where s.updatedDate =(SELECT max(s.updatedDate) from Course s)")
    Course FindBottomByOrderById();
    @Query(value ="SELECT s from Course s where s.createdDate >= :date")
    <List>Course getCourseCreatedAfterDate(@Param("date") Date date);
    @Query(value ="SELECT s from Course s where s.createdDate = :date")
    <List>Course getCourseByCreatedDate(@Param("date") Date date);
    @Query(value ="SELECT s from Course s where s.updatedDate = :date")
    <List>Course getCourseByUpdatedDate(@Param("date") Date date);
    @Query(value = "Update  Course s set s.IsActive=false where s.id=:id")
    Course deletCourseById(@Param("id") Integer id);
    @Query(value = "Update Course s set s.IsActive = false")
    Course deletAllCourse();
    @Query(value = "update Course  s set s.IsActive=false where s.name= :courseName")
    Course deleteCourseByName(@Param("courseName") String courseName);
    @Query(value ="update Course s set s.IsActive=false where s.id >= :date")
    <List>Course DeleteAllCoursesCreatedAfterDate(@Param("date") Date date);
    @Query(value ="update Course s set s.IsActive=false where s.createdDate = :date")
    <List>Course DeleteCoursesByCreatedDate(@Param("date") Date date);
    @Query(value ="update Course s set s.IsActive=false where s.createdDate = :date")
    <List>Course DeleteCoursesByUpdatedDate(@Param("date") Date date);
}
