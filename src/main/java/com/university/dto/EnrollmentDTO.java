package com.university.dto;

import java.io.Serializable;

public class EnrollmentDTO implements Serializable {
    private int id;
    private int studentId;
    private String studentName;
    private int courseId;
    private String courseTitle;
    private String enrollmentDate;

    public EnrollmentDTO() {}

    public EnrollmentDTO(int id, String enrollmentDate, String studentName, String courseTitle) {
        this.id = id;
        this.enrollmentDate = enrollmentDate;
        this.studentName = studentName;
        this.courseTitle = courseTitle;
    }

    public EnrollmentDTO(int id, int studentId, String studentName, int courseId, String courseTitle, String enrollmentDate) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.enrollmentDate = enrollmentDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

    @Override
    public String toString() {
        return "EnrollmentDTO{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                '}';
    }
}
