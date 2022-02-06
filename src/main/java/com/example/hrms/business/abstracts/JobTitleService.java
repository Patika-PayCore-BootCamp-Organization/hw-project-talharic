package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService {
    Result add(JobTitle jobTitle);

    Result update(JobTitle jobTitle);

    Result delete(JobTitle jobTitle);

    DataResult<List<JobTitle>> getAll();

    DataResult<JobTitle> getById(int id);
}
