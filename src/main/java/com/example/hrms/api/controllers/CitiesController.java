package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody City city) {
        return cityService.add(city);
    }

    @PostMapping("/update")
    public Result update(@RequestBody City city) {
        return cityService.update(city);
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<City> getById(@RequestParam int id) {
        return cityService.getById(id);
    }

}
