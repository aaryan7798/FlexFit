package com.flexfit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // This maps to login.html in templates
    }

    @GetMapping("/home")
    public String homePage() {
        return "home"; // Optional: create home.html for post-login redirect
    }
}