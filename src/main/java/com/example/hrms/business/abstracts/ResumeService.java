package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Resume;
import com.example.hrms.entities.dtos.ResumeWithAllRelatedEntitiesDto;

import java.util.List;

public interface ResumeService extends BaseEntityService<Resume> {

    Result addCoverLetterToResume(int resumeId, int coverLetterId);

    DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByActivatedCandidate();

    DataResult<Resume> getByCandidateId(int candidateId);

    DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId);

}
