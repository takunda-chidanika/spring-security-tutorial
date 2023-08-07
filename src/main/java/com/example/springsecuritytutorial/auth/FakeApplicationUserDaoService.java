package com.example.springsecuritytutorial.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.springsecuritytutorial.security.ApplicationUserRole.*;

/**
 * @author tjchidanika
 * @created 7/8/2023
 */

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getaApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equalsIgnoreCase(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getaApplicationUsers() {

        return Lists.newArrayList(
                new ApplicationUser(
                        "takunda",
                        passwordEncoder.encode("password"),
                        STUDENT.getAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "admin",
                        passwordEncoder.encode("password"),
                        ADMIN.getAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "trainee",
                        passwordEncoder.encode("password"),
                        ADMINTRAINEE.getAuthorities(),
                        true,
                        true,
                        true,
                        true
                )

        );
    }
}
