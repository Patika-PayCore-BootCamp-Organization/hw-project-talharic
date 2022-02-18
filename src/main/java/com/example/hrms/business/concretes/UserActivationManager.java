package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmailService;
import com.example.hrms.business.abstracts.UserActivationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserActivationDao;
import com.example.hrms.entities.concretes.User;
import com.example.hrms.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
        userActivation.setIsActivatedDate(LocalDateTime.now());

        userActivationDao.save(userActivation);
        return emailService.sendEmail(userActivation.getUser());
    }

    @Override
    public Result update(UserActivation userActivation) {

        userActivationDao.save(userActivation);
        return new SuccessResult();
    }

    @Override
    public Result delete(UserActivation userActivation) {

        userActivationDao.delete(userActivation);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<UserActivation>> getAll() {
        return new SuccessDataResult<List<UserActivation>>(userActivationDao.findAll());
    }

    @Override
    public DataResult<UserActivation> getById(int id) {
        return new SuccessDataResult<UserActivation>(userActivationDao.getById(id));
    }

    @Override
    public DataResult<UserActivation> getByCode(String code) {
        return new SuccessDataResult<UserActivation>(userActivationDao.getByCode(code));
    }

    @Override
    public DataResult<UserActivation> getByUserId(int userId) {
        return new SuccessDataResult<UserActivation>(userActivationDao.getByUser_Id(userId));
    }

    private String generateCode() {

        UUID code = UUID.randomUUID();

        return code.toString();
    }

}
