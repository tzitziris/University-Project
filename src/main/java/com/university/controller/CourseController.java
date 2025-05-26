package com.university.controller;

import com.university.dto.CourseDTO;
import com.university.entity.Course;
import com.university.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/dto")
    public List<CourseDTO> getAllCoursesDto() {
        return courseService.findAll().stream()
                .map(course -> {
                    String teacherName = null;
                    if (course.getTeacher() != null) {
                        teacherName = course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName();
                    }
                    return new CourseDTO(course.getId(), course.getTitle(), teacherName);
                })
                .toList();
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.findById(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        course.setId(0); // Force insert
        return courseService.save(course);
    }

    @PutMapping
    public Course updateCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
        return "Deleted course with id: " + id;
    }
}
