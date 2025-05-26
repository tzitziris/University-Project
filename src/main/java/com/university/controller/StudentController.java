package com.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.university.service.StudentService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.university.entity.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService theStudentService) {
        studentService = theStudentService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listStudents(Model theModel) {

        // get the students from db
        List<Student> theStudents = studentService.findAll();

        // add to the spring model
        theModel.addAttribute("students", theStudents);

        return "students/list-students";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "students/student-form";
    }

    @PostMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

        // get the employee from the service
        Student theStudent = studentService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        // send over to our form
        return "students/student-form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {

        // save the employee
        studentService.save(theStudent);

        // use a redirect to prevent duplicate submissions
        return "redirect:/students/list";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("studentId") int theId) {

        // delete the employee
        studentService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/students/list";

    }
}

