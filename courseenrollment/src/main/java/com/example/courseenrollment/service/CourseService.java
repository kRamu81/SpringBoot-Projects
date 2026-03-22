package com.example.courseenrollment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.courseenrollment.entity.Course;
import com.example.courseenrollment.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    // Add course
    public Course addCourse(Course course) {
        return repository.save(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return repository.findAll();
    }
}