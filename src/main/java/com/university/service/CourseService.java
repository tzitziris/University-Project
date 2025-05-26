package com.university.service;

import com.university.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(int id);
    Course save(Course course);
    void deleteById(int id);
}
