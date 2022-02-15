package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.UserConfirmationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UserConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userConfirmations")
public class UserConfirmationsController {

    private UserConfirmationService userConfirmationService;

    @Autowired
    public UserConfirmationsController(UserConfirmationService userConfirmationService) {
        this.userConfirmationService = userConfirmationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody UserConfirmation userConfirmation) {
        return userConfirmationService.add(userConfirmation);
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserConfirmation userConfirmation) {
        return userConfirmationService.update(userConfirmation);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody UserConfirmation userConfirmation) {
        return userConfirmationService.delete(userConfirmation);
    }

    @GetMapping("/getAll")
    public DataResult<List<UserConfirmation>> getAll() {
        return userConfirmationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<UserConfirmation> getById(@RequestParam int id) {
        return userConfirmationService.getById(id);
    }

}