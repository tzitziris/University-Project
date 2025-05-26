package com.university.service;

import com.university.entity.Enrollment;
import org.springframework.stereotype.Service;
import java.util.List;

public interface EnrollmentService {
    List<Enrollment> findAll();
    Enrollment findById(int id);
    Enrollment save(Enrollment enrollment);
    void deleteById(int id);
}
