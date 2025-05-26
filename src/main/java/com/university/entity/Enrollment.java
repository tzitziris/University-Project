package com.university.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "enrollment_date")
    private LocalDate enrollmentDate;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Course courses;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    // Getters and Setters

    public void setId(int id) {
        this.id = id;
    }
}