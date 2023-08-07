package com.example.springsecuritytutorial.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author tjchidanika
 * @created 3/8/2023
 */

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("courses")
    public String getCoursesView(){
        return "courses";
    }
}
