package com.example.springsecuritytutorial.student;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student.toString());
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        System.out.println(studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAnyAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Integer studentId, Student student) {
        System.out.printf("%s %s%n", studentId, student.toString());
    }
}
