package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getById")
    public DataResult<Employer> getById(@RequestParam int id) {
        return employerService.getById(id);
    }

    @PostMapping("/activate")
    public Result activate(@RequestParam String code) {
        return employerService.activate(code);
    }

    @PostMapping("/confirm")
    public Result confirm(@RequestParam int employerId, @RequestParam int companyStaffId, @RequestParam boolean isConfirmed) {
        return employerService.confirm(employerId, companyStaffId, isConfirmed);
    }

    @GetMapping("/getByIsActivatedAndIsConfirmed")
    public DataResult<List<Employer>> getAllByIsActivatedAndIsConfirmed(@RequestParam boolean isActivated, @RequestParam boolean isConfirmed) {
        return employerService.getAllByIsActivatedAndIsConfirmed(isActivated, isConfirmed);
    }

}
