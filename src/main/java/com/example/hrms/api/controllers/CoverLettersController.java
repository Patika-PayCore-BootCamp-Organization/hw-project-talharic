package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coverLetters")
public class CoverLettersController {

    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CoverLetter coverLetter) {
        return coverLetterService.add(coverLetter);
    }

    @PostMapping("/update")
    public Result update(@RequestBody CoverLetter coverLetter) {
        return coverLetterService.update(coverLetter);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody CoverLetter coverLetter) {
        return coverLetterService.delete(coverLetter);
    }

    @GetMapping("/getAll")
    public DataResult<List<CoverLetter>> getAll() {
        return coverLetterService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<CoverLetter> getById(@RequestParam int id) {
        return coverLetterService.getById(id);
    }

}
