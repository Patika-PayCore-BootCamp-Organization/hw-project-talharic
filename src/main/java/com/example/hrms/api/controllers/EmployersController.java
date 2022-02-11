package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll() {
        return employerService.getAll();
    }

    @GetMapping("/getByIsActivatedAndIsConfirmed")
    public DataResult<List<Employer>> getByIsActivatedAndIsConfirmed(boolean isActivated, boolean isConfirmed) {
        return employerService.getByIsActivatedAndIsConfirmed(isActivated, isConfirmed);
    }

    @PostMapping("/activate")
    public Result activate(String code) {
        return employerService.activate(code);
    }

    @PostMapping("/confirm")
    public Result confirm(Integer employerId, Integer companyStaffId, boolean isConfirmed) {
        return employerService.confirm(employerId, companyStaffId, isConfirmed);
    }

}
