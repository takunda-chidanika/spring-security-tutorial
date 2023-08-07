package com.example.springsecuritytutorial.jwt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author tjchidanika
 * @created 7/8/2023
 */

@NoArgsConstructor
@Getter
@Setter
public class UsernameAndPasswordAuthenticationRequest {
    private String username;
    private String password;
}
