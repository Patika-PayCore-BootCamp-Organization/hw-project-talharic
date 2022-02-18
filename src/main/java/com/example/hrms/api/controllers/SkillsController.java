package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.SkillService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillsController {

    private SkillService skillService;

    @Autowired
    public SkillsController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Skill skill) {
        return skillService.add(skill);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Skill skill) {
        return skillService.update(skill);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestBody Skill skill) {
        return skillService.delete(skill);
    }

    @GetMapping("/getAll")
    public DataResult<List<Skill>> getAll() {
        return skillService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Skill> getById(@RequestParam int id) {
        return skillService.getById(id);
    }

}