package com.example.springsecuritytutorial.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author tjchidanika
 * @created 2/8/2023
 */

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Takunda"),
            new Student(2, "Jimmy"),
            new Student(3, "Chidanika")
    );

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(Student student) {
        System.out.println(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId, Student student) {
        System.out.printf("%s %s%n", studentId, student);
    }
}
