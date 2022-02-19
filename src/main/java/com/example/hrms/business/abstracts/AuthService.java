package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.CompanyStaff;
import com.example.hrms.entities.concretes.Employer;

public interface AuthService {

    Result resgisterCompanyStaff(CompanyStaff companyStaff, String confirmPassword);

    Result resgisterCandidate(Candidate candidate, String confirmPassword);

    Result resgisterEmployer(Employer employer, String confirmPassword);

}
