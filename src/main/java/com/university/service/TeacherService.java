package com.university.service;

import com.university.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();
    Teacher findById(int id);
    Teacher save(Teacher teacher);
    void deleteById(int id);
}