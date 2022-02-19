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
@CrossOrigin
public class JobPostingConfirmationsController {

    private JobPostingConfirmationService jobPostingConfirmationService;

    @Autowired
    public JobPostingConfirmationsController(JobPostingConfirmationService jobPostingConfirmationService) {
        this.jobPostingConfirmationService = jobPostingConfirmationService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPostingConfirmation>> getAll() {
        return jobPostingConfirmationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPostingConfirmation> getById(@RequestParam int id) {
        return jobPostingConfirmationService.getById(id);
    }

    @GetMapping("/getByJobPostingId")
    public DataResult<JobPostingConfirmation> getByJobPostingId(@RequestParam int jobPostingId) {
        return jobPostingConfirmationService.getByJobPostingId(jobPostingId);
    }

}
