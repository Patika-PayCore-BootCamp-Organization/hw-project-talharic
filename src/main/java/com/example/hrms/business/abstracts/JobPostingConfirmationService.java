package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationService extends BaseEntityService<JobPostingConfirmation>{

    DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId);

}
