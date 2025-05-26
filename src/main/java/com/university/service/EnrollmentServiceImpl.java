package com.university.service;

import com.university.dao.EnrollmentRepository;
import com.university.entity.Enrollment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment findById(int id) {
        Optional<Enrollment> result = enrollmentRepository.findById(id);
        return result.orElse(null); // Επιστρέφει null αν δεν βρεθεί
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void deleteById(int id) {
        enrollmentRepository.deleteById(id);
    }
}
