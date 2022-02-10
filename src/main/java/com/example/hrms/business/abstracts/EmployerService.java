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

    Result activate(UserActivation userActivation);

}
