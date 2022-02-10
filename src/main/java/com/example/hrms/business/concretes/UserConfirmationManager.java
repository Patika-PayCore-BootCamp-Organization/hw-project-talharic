package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmailService;
import com.example.hrms.business.abstracts.UserConfirmationService;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserConfirmationDao;
import com.example.hrms.entities.concretes.UserConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserConfirmationManager implements UserConfirmationService {

    private UserConfirmationDao userConfirmationDao;
    private EmailService emailService;

    @Autowired
    public UserConfirmationManager(UserConfirmationDao userConfirmationDao, EmailService emailService) {
        this.userConfirmationDao = userConfirmationDao;
        this.emailService = emailService;
    }

    @Override
    public Result add(UserConfirmation userConfirmation) {

        userConfirmation.setIsConfirmedDate(LocalDate.now());

        if (userConfirmation.isConfirmed() == false) {

            userConfirmation.setConfirmed(false);

            userConfirmationDao.save(userConfirmation);
            emailService.sendEmail(userConfirmation.getUser());
            return new ErrorResult("Üyelik onaylanmadı.");
        }

        userConfirmation.setConfirmed(true);

        userConfirmationDao.save(userConfirmation);
        emailService.sendEmail(userConfirmation.getUser());
        return new SuccessResult("Üyelik onaylandı.");
    }

}