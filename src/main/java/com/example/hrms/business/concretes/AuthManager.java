package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.AuthService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.UserService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        if (!checkIfEmailIsValid(candidate.getEmail())) {
            return new ErrorResult("Lütfen geçerli bir e-posta adresi giriniz.");
        }

        if (checkIfEmailExists(candidate.getEmail())) {
            return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
        }

        if (!checkIfPasswordsMatch(candidate.getPassword(), confirmPassword)) {
            return new ErrorResult("Parola eşleşmesi gerçekleşmedi. Lütfen kontrol ederek yeniden deneyiniz.");
        }

        return candidateService.add(candidate);
    }

    @Override
    public Result resgisterEmployer(Employer employer, String confirmPassword) {

        if (!checkIfEmailIsValid(employer.getEmail())) {
            return new ErrorResult("Lütfen geçerli bir e-posta adresi giriniz.");
        }

        if (checkIfEmailExists(employer.getEmail())) {
            return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
        }

        if (!checkIfPasswordsMatch(employer.getPassword(), confirmPassword)) {
            return new ErrorResult("Parola eşleşmesi gerçekleşmedi. Lütfen kontrol ederek yeniden deneyiniz.");
        }

        return employerService.add(employer);
    }

    private boolean checkIfEmailIsValid(String email) {

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean checkIfEmailExists(String email) {

        boolean result = false;

        for (User user : userService.getAll().getData()) {
            if (user.getEmail() == email) {
                result = true;
            }
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
