package com.example.springsecuritytutorial.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tjchidanika
 * @created 2/8/2023
 *
 */

@AllArgsConstructor
@Getter
public enum ApplicationUserPermissions {
    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

}
