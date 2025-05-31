package com.university.controller;

import com.university.entity.Teacher;
import com.university.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
@CrossOrigin(origins = "http://localhost:5173/")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService theTeacherService) {
        this.teacherService = theTeacherService;
    }

    // GET all teachers
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.findAll();
    }

    // GET one teacher by id
    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService.findById(id);
    }

    // POST - create new teacher
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher theTeacher) {
        theTeacher.setId(0); // force creation
        return teacherService.save(theTeacher);
    }

    // PUT - update teacher
    @PutMapping
    public Teacher updateTeacher(@RequestBody Teacher theTeacher) {
        return teacherService.save(theTeacher);
    }

    // DELETE - delete teacher by id
    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable int id) {
        teacherService.deleteById(id);
        return "Deleted teacher with id: " + id;
    }
}
