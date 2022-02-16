package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Language language) {
        return languageService.add(language);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Language language) {
        return languageService.update(language);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Language language) {
        return languageService.delete(language);
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Language> getById(@RequestParam int id) {
        return languageService.getById(id);
    }

}
