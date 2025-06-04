package com.university.controller;

import com.university.entity.Student;
import com.university.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    // GET one student by id
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    // POST - create new student
    @PostMapping
    public Student createStudent(@RequestBody Student theStudent) {
        theStudent.setId(0); // force creation
        return studentService.save(theStudent);
    }

    // PUT - update student
    @PutMapping
    public Student updateStudent(@RequestBody Student theStudent) {
        return studentService.save(theStudent);
    }

    // DELETE - delete student by id
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
        return "Deleted student with id: " + id;
    }
}
