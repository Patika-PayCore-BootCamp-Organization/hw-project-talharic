package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService extends BaseEntityService<CoverLetter> {

    DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId);

}
