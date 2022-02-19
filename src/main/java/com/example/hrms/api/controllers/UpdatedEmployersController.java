package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.UpdatedEmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.UpdatedEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/updatedEmployers")
@CrossOrigin
class UpdatedEmployersController {

    private UpdatedEmployerService updatedEmployerService;

    @Autowired
    public UpdatedEmployersController(UpdatedEmployerService updatedEmployerService) {
        this.updatedEmployerService = updatedEmployerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<UpdatedEmployer>> getAll() {
        return updatedEmployerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<UpdatedEmployer> getById(@RequestParam int id) {
        return updatedEmployerService.getById(id);
    }

    @GetMapping("/getByEmployerId")
    public DataResult<UpdatedEmployer> getByEmployerId(@RequestParam int employerId) {
        return updatedEmployerService.getByEmployerId(employerId);
    }

}
