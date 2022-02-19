package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobPostingConfirmationTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPostingConfirmationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostingConfirmationTypes")
@CrossOrigin
public class JobPostingConfirmationTypesController {

    private JobPostingConfirmationTypeService jobPostingConfirmationTypeService;

    @Autowired
    public JobPostingConfirmationTypesController(JobPostingConfirmationTypeService jobPostingConfirmationTypeService) {
        this.jobPostingConfirmationTypeService = jobPostingConfirmationTypeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPostingConfirmationType jobPostingConfirmationType) {
        return jobPostingConfirmationTypeService.add(jobPostingConfirmationType);
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobPostingConfirmationType jobPostingConfirmationType) {
        return jobPostingConfirmationTypeService.update(jobPostingConfirmationType);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPostingConfirmationType>> getAll() {
        return jobPostingConfirmationTypeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPostingConfirmationType> getById(@RequestParam int id) {
        return jobPostingConfirmationTypeService.getById(id);
    }

}
