package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobTitle;

import java.util.List;

public interface JobTitleService extends BaseEntityService<JobTitle>{

    DataResult<JobTitle> getByTitle(String title);

}

