package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmailService;
import com.example.hrms.business.abstracts.UserActivationService;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserActivationDao;
import com.example.hrms.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserActivationManager implements UserActivationService {

    private UserActivationDao userActivationDao;
    private EmailService emailService;

    @Autowired
    public UserActivationManager(UserActivationDao userActivationDao, EmailService emailService) {
        this.userActivationDao = userActivationDao;
        this.emailService = emailService;
    }

    @Override
    public Result add(UserActivation userActivation) {

        userActivation.setCode(generateCode());
        userActivation.setActivated(false);
        userActivation.setIsActivatedDate(LocalDate.now());

        userActivationDao.save(userActivation);
        return emailService.sendEmail(userActivation.getUser());
    }

    @Override
    public Result update(UserActivation userActivation) {

        userActivationDao.save(userActivation);
        return new SuccessResult();
    }

    private String generateCode() {

        UUID code = UUID.randomUUID();

        return code.toString();
    }

}
