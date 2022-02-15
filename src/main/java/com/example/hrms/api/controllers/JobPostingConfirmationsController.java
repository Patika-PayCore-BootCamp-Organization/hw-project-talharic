package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobPostingConfirmationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPostingConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostingConfirmations")
public class JobPostingConfirmationsController {

    private JobPostingConfirmationService jobPostingConfirmationService;

    @Autowired
    public JobPostingConfirmationsController(JobPostingConfirmationService jobPostingConfirmationService) {
        this.jobPostingConfirmationService = jobPostingConfirmationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPostingConfirmation jobPostingConfirmation) {
        return jobPostingConfirmationService.add(jobPostingConfirmation);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobPostingConfirmation jobPostingConfirmation) {
        return jobPostingConfirmationService.update(jobPostingConfirmation);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobPostingConfirmation jobPostingConfirmation) {
        return jobPostingConfirmationService.delete(jobPostingConfirmation);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPostingConfirmation>> getAll() {
        return jobPostingConfirmationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPostingConfirmation> getById(@RequestParam int id) {
        return jobPostingConfirmationService.getById(id);
    }

}
