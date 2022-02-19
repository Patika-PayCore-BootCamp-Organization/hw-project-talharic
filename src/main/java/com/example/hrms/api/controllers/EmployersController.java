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
@CrossOrigin
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PutMapping("/update")
    public Result update(@RequestBody Employer employer) {
        return employerService.update(employer);
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll() {
        return employerService.getAll();
    }

    @GetMapping("getById")
    public DataResult<Employer> getById(@RequestParam int id) {
        return employerService.getById(id);
    }

    @PutMapping("/activate")
    public Result activate(@RequestParam String code) {
        return employerService.activate(code);
    }

    @PutMapping("/confirm")
    public Result confirm(@RequestParam int employerId, @RequestParam int companyStaffId, @RequestParam int userConfirmationTypeId, @RequestParam boolean isConfirmed) {
        return employerService.confirm(employerId, companyStaffId, userConfirmationTypeId, isConfirmed);
    }

    @GetMapping("/getAllByIsActivated")
    public DataResult<List<Employer>> getAllByIsActivated(@RequestParam boolean isActivated) {
        return employerService.getAllByIsActivated(isActivated);
    }

    @GetMapping("/getAllByIsConfirmedAndUserConfirmationTypeId")
    public DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeId(@RequestParam boolean isConfirmed, @RequestParam int userConfirmationTypeId) {
        return employerService.getAllByIsConfirmedAndUserConfirmationTypeId(isConfirmed, userConfirmationTypeId);
    }

}
