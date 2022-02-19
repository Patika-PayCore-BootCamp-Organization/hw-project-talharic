package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education) {
        return educationService.add(education);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Education education) {
        return educationService.update(education);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return educationService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll() {
        return educationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Education> getById(@RequestParam int id) {
        return educationService.getById(id);
    }

    @GetMapping("/getAllByResumeIdSortedByGraduationDate")
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(@RequestParam int resumeId) {
        return educationService.getAllByResumeIdSortedByGraduationDate(resumeId);
    }

}
