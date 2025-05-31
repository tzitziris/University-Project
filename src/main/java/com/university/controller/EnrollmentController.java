package com.university.controller;

import com.university.dto.EnrollmentDTO;
import com.university.entity.Enrollment;
import com.university.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "http://localhost:5173/")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/dto")
    public List<EnrollmentDTO> getAllEnrollmentsDto() {
        return enrollmentService.findAll().stream().map(enrollment -> {
            String studentName = "";
            String courseTitle = "";

            if (enrollment.getStudent() != null) {
                studentName = enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName();
            }

            if (enrollment.getCourse() != null) {
                courseTitle = enrollment.getCourse().getTitle();
            }

            return new EnrollmentDTO(
                    enrollment.getId(),
                    enrollment.getEnrollmentDate() != null ? enrollment.getEnrollmentDate().toString() : null,
                    studentName,
                    courseTitle
            );
        }).toList();
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