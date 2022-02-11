package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.UserActivation;

import java.util.List;

public interface EmployerService {

    Result add(Employer employer);

    Result update(Employer employer);

    Result delete(Employer employer);

    DataResult<List<Employer>> getAll();

    DataResult<Employer> getById(int id);

    DataResult<List<Employer>> getByIsActivatedAndIsConfirmed(boolean isActivated, boolean isConfirmed);

    Result activate(String code);

    Result confirm(Integer employerId, Integer companyStaffId, boolean isConfirmed);

}
