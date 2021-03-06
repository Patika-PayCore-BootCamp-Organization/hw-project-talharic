package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.CompanyStaffService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CompanyStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companyStaffs")
@CrossOrigin
public class CompanyStaffsController {

    private CompanyStaffService companyStaffService;

    @Autowired
    public CompanyStaffsController(CompanyStaffService companyStaffService) {
        this.companyStaffService = companyStaffService;
    }

    @PutMapping("/update")
    public Result update(@RequestBody CompanyStaff companyStaff) {
        return companyStaffService.update(companyStaff);
    }

    @GetMapping("/getAll")
    public DataResult<List<CompanyStaff>> getAll() {
        return companyStaffService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<CompanyStaff> getById(@RequestParam int id) {
        return companyStaffService.getById(id);
    }

}
