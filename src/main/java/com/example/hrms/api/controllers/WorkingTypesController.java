package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.WorkingTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workingTypes")
@CrossOrigin
public class WorkingTypesController {

    private WorkingTypeService workingTypeService;

    @Autowired
    public WorkingTypesController(WorkingTypeService workingTypeService) {
        this.workingTypeService = workingTypeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody WorkingType workingType) {
        return workingTypeService.add(workingType);
    }

    @PostMapping("/update")
    public Result update(@RequestBody WorkingType workingType) {
        return workingTypeService.update(workingType);
    }

    @GetMapping("/getAll")
    public DataResult<List<WorkingType>> getAll() {
        return workingTypeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<WorkingType> getById(@RequestParam int id) {
        return workingTypeService.getById(id);
    }

}
