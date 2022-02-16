package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.WorkingTimeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workingTimes")
@CrossOrigin
public class WorkingTimesController {

    private WorkingTimeService workingTimeService;

    @Autowired
    public WorkingTimesController(WorkingTimeService workingTimeService) {
        this.workingTimeService = workingTimeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkingTime workingTime) {
        return workingTimeService.add(workingTime);
    }

    @PostMapping("/update")
    public Result update(@RequestBody WorkingTime workingTime) {
        return workingTimeService.update(workingTime);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody WorkingTime workingTime) {
        return workingTimeService.delete(workingTime);
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkingTime>> getAll() {
        return workingTimeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<WorkingTime> getById(@RequestParam int id) {
        return workingTimeService.getById(id);
    }

}
