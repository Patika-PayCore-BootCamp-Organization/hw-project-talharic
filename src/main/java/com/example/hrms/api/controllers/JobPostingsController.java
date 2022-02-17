package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;
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

    @GetMapping("/getAll")
    public DataResult<List<JobPosting>> getAll() {
        return jobPostingService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPosting> getById(@RequestParam int id) {
        return jobPostingService.getById(id);
    }

    @PostMapping("/confirm")
    public Result confirm(@RequestParam int jobPostingId, @RequestParam int companyStaffId,	@RequestParam boolean isConfirmed) {
        return jobPostingService.confirm(jobPostingId, companyStaffId, isConfirmed);
    }

    @PostMapping("/makeActiveOrPassive")
    public Result makeActiveOrPassive(@RequestParam int id, @RequestParam boolean isActive) {
        return jobPostingService.makeActiveOrPassive(id, isActive);
    }

    @GetMapping("/getAllActiveOnes")
    public DataResult<List<JobPosting>> getAllActiveOnes() {
        return jobPostingService.getAllActiveOnes();
    }

    @GetMapping("/getAllActiveOnesByPage")
    public DataResult<List<JobPosting>> getAllActiveOnesByPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        return jobPostingService.getAllActiveOnesByPage(pageNo, pageSize);
    }

    @GetMapping("/getAllActiveOnesSortedByPostingDate")
    public DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDate() {
        return jobPostingService.getAllActiveOnesSortedByPostingDate();
    }

    @GetMapping("/getAllActiveOnesByPageSortedByPostingDate")
    public DataResult<List<JobPosting>> getAllActiveOnesByPageSortedByPostingDate(@RequestParam int pageNo,	@RequestParam int pageSize) {
        return jobPostingService.getAllActiveOnesByPageSortedByPostingDate(pageNo, pageSize);
    }

    @GetMapping("/getAllActiveOnesSortedByPostingDateTop6")
    public DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDateTop6() {
        return jobPostingService.getAllActiveOnesSortedByPostingDateTop6();
    }

    @GetMapping("/getAllActiveOnesByEmployerId")
    public DataResult<List<JobPosting>> getAllActiveOnesByEmployerId(@RequestParam int employerId) {
        return jobPostingService.getAllActiveOnesByEmployerId(employerId);
    }

    @GetMapping("/getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType")
    public DataResult<List<JobPosting>> getAllActiveOnesFilteredByWorkingTimeAndWorkingTypeAndCityAndJobTitle(@RequestParam int cityId, @RequestParam int jobTitleId,
                                                                                                              @RequestParam int workingTimeId, @RequestParam int workingTypeId) {
        return jobPostingService.getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(cityId, jobTitleId, workingTimeId, workingTypeId);
    }

    @GetMapping("/getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType")
    public DataResult<List<JobPosting>> getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(@RequestParam int cityId, @RequestParam int jobTitleId,
                                                                                                                    @RequestParam int workingTimeId, @RequestParam int workingTypeId, @RequestParam int pageNo, @RequestParam int pageSize) {
        return jobPostingService.getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(cityId, jobTitleId, workingTimeId, workingTypeId, pageNo, pageSize);
    }

}
