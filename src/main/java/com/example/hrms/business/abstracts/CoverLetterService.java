package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService extends BaseEntityService<CoverLetter> {

    DataResult<CoverLetter> getByCandidateId(int candidateId);

}
