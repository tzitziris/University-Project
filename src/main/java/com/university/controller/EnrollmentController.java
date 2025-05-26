package com.university.controller;

import com.university.entity.Enrollment;
import com.university.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // GET all enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.findAll();
    }

    // GET one enrollment by id
    @GetMapping("/{id}")
    public Enrollment getEnrollmentById(@PathVariable int id) {
        return enrollmentService.findById(id);
    }

    // POST - create new enrollment
    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        enrollment.setId(0); // force insert
        return enrollmentService.save(enrollment);
    }

    // PUT - update enrollment
    @PutMapping
    public Enrollment updateEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    // DELETE - delete enrollment by id
    @DeleteMapping("/{id}")
    public String deleteEnrollment(@PathVariable int id) {
        enrollmentService.deleteById(id);
        return "Deleted enrollment with id: " + id;
    }
}