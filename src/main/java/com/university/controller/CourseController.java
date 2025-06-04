package com.university.controller;

import com.university.dao.CourseRepository;
import com.university.dto.CourseDTO;
import com.university.entity.Course;
import com.university.entity.Teacher;
import com.university.service.CourseService;
import com.university.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:5173/")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseRepository courseRepository;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/dto")
    public List<CourseDTO> getAllCoursesDto() {
        return courseRepository.findAll().stream().map(course -> {
            CourseDTO dto = new CourseDTO();
            dto.setId(course.getId());
            dto.setTitle(course.getTitle());
            dto.setDescription(course.getDescription());
            if (course.getTeacher() != null) {
                dto.setTeacherId(course.getTeacher().getId());
                dto.setTeacherFullName(course.getTeacher().getFirstName() + " " + course.getTeacher().getLastName());
            }
            return dto;
        }).collect(Collectors.toList());
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

        if (course.getTeacher() != null && course.getTeacher().getId() != 0) {
            Teacher teacher = teacherService.findById(course.getTeacher().getId());
            course.setTeacher(teacher);
        }

        return courseService.save(course);
    }

//    @PutMapping
//    public Course updateCourse(@RequestBody Course course) {
//        return courseService.save(course);
//    }

    @PutMapping
    public Course updateCourse(@RequestBody Course course) {
        Course existingCourse = courseService.findById(course.getId());
        if (existingCourse == null) {
            throw new RuntimeException("Course not found with id: " + course.getId());
        }

        // Αν θέλεις να ενημερώσεις τον τίτλο
        if (course.getTitle() != null) {
            existingCourse.setTitle(course.getTitle());
        }

        // Αν θέλεις να ενημερώσεις την περιγραφή
        if (course.getDescription() != null) {
            existingCourse.setDescription(course.getDescription());
        }

        // Αν θέλεις να ενημερώσεις τον teacher
        if (course.getTeacher() != null && course.getTeacher().getId() != 0) {
            Teacher teacher = teacherService.findById(course.getTeacher().getId());
            if (teacher == null) {
                throw new RuntimeException("Teacher not found with id: " + course.getTeacher().getId());
            }
            existingCourse.setTeacher(teacher);
        }

        return courseService.save(existingCourse);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseService.deleteById(id);
        return "Deleted course with id: " + id;
    }
}
