package com.university.dto;

public class CourseDTO {
    private int id;
    private String title;
    private String teacherFullName;

    public CourseDTO(int id, String title, String teacherFullName) {
        this.id = id;
        this.title = title;
        this.teacherFullName = teacherFullName;
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
}
