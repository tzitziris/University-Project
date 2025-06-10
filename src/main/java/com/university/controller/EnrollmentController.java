package com.university.controller;

import com.university.dao.CourseRepository;
import com.university.dao.EnrollmentRepository;
import com.university.dao.StudentRepository;
import com.university.dto.EnrollmentDTO;
import com.university.entity.Course;
import com.university.entity.Enrollment;
import com.university.entity.Student;
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
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentController(EnrollmentService enrollmentService, EnrollmentRepository enrollmentRepository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.enrollmentService = enrollmentService;
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
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
        // Φέρε τα πραγματικά entities από τη βάση
        int studentId = enrollment.getStudent().getId();
        int courseId = enrollment.getCourse().getId();

        // Χρησιμοποιείς το EntityManager ή ένα StudentRepository/CourseRepository
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        // Βάλε τα σωστά managed entities
        enrollment.setStudent(student);
        enrollment.setCourse(course);

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