package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.UserActivationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userActivations")
public class UserActivationsController {

    private UserActivationService userActivationService;

    @Autowired
    public UserActivationsController(UserActivationService userActivationService) {
        this.userActivationService = userActivationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody UserActivation userActivation) {
        return userActivationService.add(userActivation);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserActivation userActivation) {
        return userActivationService.update(userActivation);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody UserActivation userActivation) {
        return userActivationService.delete(userActivation);
    }

    @GetMapping("/getAll")
    public DataResult<List<UserActivation>> getAll() {
        return userActivationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<UserActivation> getById(@RequestParam int id) {
        return userActivationService.getById(id);
    }

}