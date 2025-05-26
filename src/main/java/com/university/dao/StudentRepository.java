package com.university.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.university.entity.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer>{
    public List<Student> findAllByOrderByLastNameAsc();
}

