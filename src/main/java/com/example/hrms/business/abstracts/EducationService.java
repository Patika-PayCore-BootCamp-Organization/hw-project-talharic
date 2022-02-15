package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService extends BaseEntityService<Education> {

    DataResult<List<Education>> getAllByResumeId(int resumeId);

    DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId);

}
