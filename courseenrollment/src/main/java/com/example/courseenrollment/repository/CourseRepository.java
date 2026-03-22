package com.example.courseenrollment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.courseenrollment.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}