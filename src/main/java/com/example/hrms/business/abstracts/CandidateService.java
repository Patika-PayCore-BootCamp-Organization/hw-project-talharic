package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.UserActivation;

import java.util.List;

public interface CandidateService extends BaseEntityService<Candidate> {

    Result activate(String code);

    DataResult<List<Candidate>> getAllByIsActivated(boolean isActivated);

    DataResult<Candidate> getByIdentityNumber(String identityNumber);

}
