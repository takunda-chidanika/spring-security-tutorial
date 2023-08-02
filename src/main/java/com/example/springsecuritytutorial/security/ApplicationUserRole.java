package com.example.springsecuritytutorial.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

import static com.example.springsecuritytutorial.security.ApplicationUserPermissions.*;

/**
 * @author tjchidanika
 * @created 2/8/2023
 */

@AllArgsConstructor
@Getter
public enum ApplicationUserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    private final Set<ApplicationUserPermissions> permissions;

}
