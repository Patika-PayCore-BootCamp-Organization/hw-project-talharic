package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll() {
        return candidateService.getAll();
    }

    @GetMapping("getById")
    public DataResult<Candidate> getById(@RequestParam int id) {
        return candidateService.getById(id);
    }

    @PostMapping("/activate")
    public Result activate(@RequestParam String code) {
        return candidateService.activate(code);
    }

}