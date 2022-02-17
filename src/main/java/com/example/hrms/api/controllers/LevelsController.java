package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.LevelService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@CrossOrigin
public class LevelsController {

    private LevelService levelService;

    @Autowired
    public LevelsController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Level level) {
        return levelService.add(level);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Level level) {
        return levelService.update(level);
    }

    @GetMapping("/getAll")
    public DataResult<List<Level>> getAll() {
        return levelService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Level> getById(@RequestParam int id) {
        return levelService.getById(id);
    }

}
