package com.example.springsecuritytutorial.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author tjchidanika
 * @created 2/8/2023
 */

@RestController
@RequestMapping("/api/v1/students/")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Takunda"),
            new Student(2, "Jimmy"),
            new Student(3, "Chidanika")
    );

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student with id " + studentId + "does not exist"));
    }
}
