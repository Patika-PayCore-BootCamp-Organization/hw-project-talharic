package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registerCandidate")
    public Result registerCandidate(@RequestBody Candidate candidate, String confirmPassword) {
        return authService.resgisterCandidate(candidate, confirmPassword);
    }

    @PostMapping("/registerEmployer")
    public Result registerEmployer(@RequestBody Employer employer, String confirmPassword) {
        return authService.resgisterEmployer(employer, confirmPassword);
    }

}
