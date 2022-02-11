package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmailService;
import com.example.hrms.business.abstracts.UserConfirmationService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.UserConfirmationDao;
import com.example.hrms.entities.concretes.UserConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

        userConfirmationDao.save(userConfirmation);
        emailService.sendEmail(userConfirmation.getUser());
        return new SuccessResult();
    }

    @Override
    public Result update(UserConfirmation userConfirmation) {

        userConfirmationDao.save(userConfirmation);
        return new SuccessResult();
    }

    @Override
    public Result delete(UserConfirmation userConfirmation) {

        userConfirmationDao.delete(userConfirmation);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<UserConfirmation>> getAll() {
        return new SuccessDataResult<List<UserConfirmation>>(userConfirmationDao.findAll());
    }

    @Override
    public DataResult<UserConfirmation> getById(int id) {
        return new SuccessDataResult<UserConfirmation>(userConfirmationDao.getById(id));
    }

}