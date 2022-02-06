package com.example.hrms.api.controllers;

import java.util.List;

import com.example.hrms.business.abstracts.JobTitleService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-titles")
public class JobTitlesController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        super();
        this.jobTitleService = jobTitleService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.add(jobTitle);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.update(jobTitle);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobTitle jobTitle) {
        return this.jobTitleService.delete(jobTitle);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobTitle> getById(@RequestParam int id) {
        return this.jobTitleService.getById(id);
    }


}
