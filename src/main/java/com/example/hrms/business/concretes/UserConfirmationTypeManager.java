package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UserConfirmationTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserConfirmationTypeDao;
import com.example.hrms.entities.concretes.UserConfirmationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConfirmationTypeManager implements UserConfirmationTypeService {

    private UserConfirmationTypeDao userConfirmationTypeDao;

    @Autowired
    public UserConfirmationTypeManager(UserConfirmationTypeDao userConfirmationTypeDao) {
        this.userConfirmationTypeDao = userConfirmationTypeDao;
    }

    @Override
    public Result add(UserConfirmationType userConfirmationType) {

        userConfirmationTypeDao.save(userConfirmationType);
        return new SuccessResult("Onay tipi eklendi.");
    }

    @Override
    public Result update(UserConfirmationType userConfirmationType) {

        userConfirmationTypeDao.save(userConfirmationType);
        return new SuccessResult("Onay tipi güncellendi.");
    }

    @Override
    public Result delete(int id) {

        userConfirmationTypeDao.deleteById(id);
        return new SuccessResult("Onay tipi silindi.");
    }

    @Override
    public DataResult<List<UserConfirmationType>> getAll() {
        return new SuccessDataResult<List<UserConfirmationType>>(userConfirmationTypeDao.findAll());
    }

    @Override
    public DataResult<UserConfirmationType> getById(int id) {
        return new SuccessDataResult<UserConfirmationType>(userConfirmationTypeDao.getById(id));
    }

}
