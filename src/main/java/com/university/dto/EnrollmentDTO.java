package com.university.dto;

public class EnrollmentDTO {
    private int id;
    private String enrollmentDate;
    private String studentName;
    private String courseTitle;

    public EnrollmentDTO(int id, String enrollmentDate, String studentName, String courseTitle) {
        this.id = id;
        this.enrollmentDate = enrollmentDate;
        this.studentName = studentName;
        this.courseTitle = courseTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
