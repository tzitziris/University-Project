package com.university.service;


import java.util.List;

import com.university.entity.Student;

public interface StudentService {

    List<Student> findAll();

    Student findById(int theId);

    Student save(Student theStudent);

    void deleteById(int theId);

}