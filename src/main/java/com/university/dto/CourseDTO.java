package com.university.dto;

import lombok.Getter;
import lombok.Setter;

public class CourseDTO {
    private int id;
    private String title;
    private String teacherFullName;
;
    private String description;
    private int teacherId;

    public CourseDTO() {}

    public CourseDTO(int id, String title, String teacherFullName) {
        this.id = id;
        this.title = title;
        this.teacherFullName = teacherFullName;
    }

    public CourseDTO(int id, String title, String teacherFullName, String description, int teacherId) {
        this.id = id;
        this.title = title;
        this.teacherFullName = teacherFullName;
        this.description = description;
        this.teacherId = teacherId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTeacherFullName() {
        return teacherFullName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTeacherFullName(String teacherFullName) {
        this.teacherFullName = teacherFullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
}
