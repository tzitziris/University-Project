package com.university.controller;

import com.university.dao.EnrollmentRepository;
import com.university.dto.EnrollmentDTO;
import com.university.entity.Enrollment;
import com.university.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "http://localhost:5173/")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentController(EnrollmentService enrollmentService, EnrollmentRepository enrollmentRepository) {
        this.enrollmentService = enrollmentService;
        this.enrollmentRepository = enrollmentRepository;
    }

    @GetMapping("/dto")
    public List<EnrollmentDTO> getAllEnrollmentsDto() {
        return enrollmentRepository.findAll().stream().map(enrollment -> {
            EnrollmentDTO dto = new EnrollmentDTO();
            dto.setId(enrollment.getId());
            dto.setEnrollmentDate(enrollment.getEnrollmentDate().toString());
            if (enrollment.getStudent() != null) {
                dto.setStudentId(enrollment.getStudent().getId());
                dto.setStudentName(enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName());
            }
            if (enrollment.getCourse() != null) {
                dto.setCourseId(enrollment.getCourse().getId());
                dto.setCourseTitle(enrollment.getCourse().getTitle());
            }
            return dto;
        }).collect(Collectors.toList());
    }

//    @GetMapping("/dto")
//    public List<EnrollmentDTO> getAllEnrollmentsDto() {
//        return enrollmentService.findAll().stream().map(enrollment -> {
//            String studentName = "";
//            String courseTitle = "";
//
//            if (enrollment.getStudent() != null) {
//                studentName = enrollment.getStudent().getFirstName() + " " + enrollment.getStudent().getLastName();
//            }
//
//            if (enrollment.getCourse() != null) {
//                courseTitle = enrollment.getCourse().getTitle();
//            }
//
//            return new EnrollmentDTO(
//                    enrollment.getId(),
//                    enrollment.getEnrollmentDate() != null ? enrollment.getEnrollmentDate().toString() : null,
//                    studentName,
//                    courseTitle
//            );
//        }).toList();
//    }

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