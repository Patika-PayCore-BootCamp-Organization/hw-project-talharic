package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.LinkNameService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.LinkName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linkNames")
@CrossOrigin
public class LinkNamesController {

    private LinkNameService linkNameService;

    @Autowired
    public LinkNamesController(LinkNameService linkNameService) {
        this.linkNameService = linkNameService;
    }

    @PostMapping("/add")
    public Result add(LinkName linkName) {
        return linkNameService.add(linkName);
    }

    @PostMapping("/update")
    public Result update(LinkName linkName) {
        return linkNameService.update(linkName);
    }

    @GetMapping("/getAll")
    public DataResult<List<LinkName>> getAll() {
        return linkNameService.getAll();
    }

    @GetMapping("getById")
    public DataResult<LinkName> getById(@RequestParam int id) {
        return linkNameService.getById(id);
    }

}
