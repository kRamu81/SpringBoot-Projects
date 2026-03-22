package com.example.courseenrollment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.courseenrollment.entity.Course;
import com.example.courseenrollment.service.CourseService;

@RestController
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService service;

    // API to add a course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return service.addCourse(course);
    }

    // API to get all courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return service.getAllCourses();
    }
}