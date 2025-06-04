package com.university.service;

import com.university.dao.CourseRepository;
import com.university.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(int id) {
        Optional<Course> result = courseRepository.findById(id);
        return result.orElse(null); // ή πέτα exception αν προτιμάς
    }

    @Override
    public Course save(Course course) {

        return courseRepository.save(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }
}
