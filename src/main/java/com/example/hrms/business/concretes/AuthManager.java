package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthManager implements AuthService {

    private UserService userService;
    private CandidateService candidateService;
    private EmployerService employerService;

    @Autowired
    public AuthManager(UserService userService, CandidateService candidateService, EmployerService employerService) {
        this.userService = userService;
        this.candidateService = candidateService;
        this.employerService = employerService;
    }

    @Override
    public Result resgisterCandidate(Candidate candidate, String confirmPassword) {

        if (!checkIfEmailExists(candidate.getEmail())) {
            return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
        }

        if (!checkIfPasswordsMatch(candidate.getPassword(), confirmPassword)) {
            return new ErrorResult("Parola eşleşmesi gerçekleşmedi. Lütfen kontrol ederek yeniden deneyiniz.");
        }

        return candidateService.add(candidate);
    }

    @Override
    public Result resgisterEmployer(Employer employer, String confirmPassword) {

        if (!checkIfEmailExists(employer.getEmail())) {
            return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
        }

        if (!checkIfPasswordsMatch(employer.getPassword(), confirmPassword)) {
            return new ErrorResult("Parola eşleşmesi gerçekleşmedi. Lütfen kontrol ederek yeniden deneyiniz.");
        }

        return employerService.add(employer);
    }

    private boolean checkIfEmailExists(String email) {

        boolean result = false;

        if (userService.getByEmail(email).getData() == null) {
            result = true;
        }

        return result;
    }

    private boolean checkIfPasswordsMatch(String password, String confirmPassword) {

        boolean result = false;

        if (password.equals(confirmPassword)) {
            result = true;
        }

        return result;
    }

}
