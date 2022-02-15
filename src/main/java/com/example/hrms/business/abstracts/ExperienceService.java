package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService extends BaseEntityService<Experience> {

    DataResult<List<Experience>> getAllByResumeId(int resumeId);

    DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId);

}
