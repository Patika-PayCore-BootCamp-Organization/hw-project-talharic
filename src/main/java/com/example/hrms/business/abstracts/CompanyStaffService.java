package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.CompanyStaff;

import java.util.List;

public interface CompanyStaffService {

    Result add(CompanyStaff companyStaff);

    Result update(CompanyStaff companyStaff);

    Result delete(CompanyStaff companyStaff);

    DataResult<List<CompanyStaff>> getAll();

    DataResult<CompanyStaff> getById(int id);

}
