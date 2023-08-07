package com.example.springsecuritytutorial.auth;

import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author tjchidanika
 * @created 7/8/2023
 */
@Repository
public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}
