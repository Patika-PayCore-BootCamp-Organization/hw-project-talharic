package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
@CrossOrigin
public class JobPostingsController {

    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingsController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting) {
        return jobPostingService.add(jobPosting);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobPosting jobPosting) {
        return jobPostingService.delete(jobPosting);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosting>> getAll() {
        return jobPostingService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPosting> getById(@RequestParam int id) {
        return jobPostingService.getById(id);
    }

    @PostMapping("/confirm")
    public Result confirm(@RequestParam int jobPostingId, @RequestParam int companyStaffId, @RequestParam boolean isConfirmed) {
        return jobPostingService.confirm(jobPostingId, companyStaffId, isConfirmed);
    }

    @PostMapping("/doActiveOrPassive")
    public Result doActiveOrPassive(@RequestParam int id, @RequestParam boolean isActive) {
        return jobPostingService.doActiveOrPassive(id, isActive);
    }

    @GetMapping("/getAllActiveJobPostingDetails")
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetails() {
        return jobPostingService.getAllActiveJobPostingDetails();
    }

    @GetMapping("/getAllActiveJobPostingDetailsSortedByPostingDate")
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetailsSortedByPostingDate() {
        return jobPostingService.getAllActiveJobPostingDetailsSortedByPostingDate();
    }

    @GetMapping("/getAllActiveJobPostingDetailsSortedByPostingDateTop6")
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetailsSortedByPostingDateTop6() {
        return jobPostingService.getAllActiveJobPostingDetailsSortedByPostingDateTop6();
    }

    @GetMapping("/getAllActiveJobPostingDetailsByCompanyName")
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetailsByCompanyName(@RequestParam String companyName) {
        return jobPostingService.getAllActiveJobPostingDetailsByCompanyName(companyName);
    }

}
