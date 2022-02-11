package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.User;
import com.example.hrms.entities.concretes.UserActivation;

import java.util.List;

public interface UserActivationService {

    Result add(UserActivation userActivation);

    Result update(UserActivation userActivation);

    Result delete(UserActivation userActivation);

    DataResult<List<UserActivation>> getAll();

    DataResult<UserActivation> getById(int id);

    DataResult<UserActivation> getByCode(String code);

    DataResult<UserActivation> getByUser(User user);

}
