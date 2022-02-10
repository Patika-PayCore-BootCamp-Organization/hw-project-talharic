package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.UserActivation;

import java.util.List;

public interface CandidateService {

    Result add(Candidate candidate);

    Result update(Candidate candidate);

    Result delete(Candidate candidate);

    DataResult<List<Candidate>> getAll();

    DataResult<Candidate> getById(int id);

    DataResult<Candidate> getByIdentityNumber(String identityNumber);

    Result activate(UserActivation userActivation);

}
