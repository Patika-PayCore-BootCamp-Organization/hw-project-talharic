package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobTitleDto;

import java.util.List;

public interface JobPostingService {

    Result add(JobPosting jobPosting);

    Result update(JobPosting jobPosting);

    Result delete(JobPosting jobPosting);

    DataResult<List<JobPosting>> getAll();

    DataResult<JobPosting> getById(int id);

    DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetails();

    DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetailsSortedByPostingDate();

    DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetailsByCompanyName(String companyName);

}