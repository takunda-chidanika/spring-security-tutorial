package com.example.springsecuritytutorial.student;

import lombok.*;

/**
 * @author tjchidanika
 * @created 2/8/2023
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private Integer studentId;
    private String studentName;
}
