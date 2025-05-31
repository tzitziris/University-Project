package com.university.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference(value = "course-enrollments")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference(value = "student-enrollments")
    private Student student;

    public void setId(int id) {
        this.id = id;
    }
}


