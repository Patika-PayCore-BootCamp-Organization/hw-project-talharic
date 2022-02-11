package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UserConfirmation;

import java.util.List;

public interface UserConfirmationService {

    Result add(UserConfirmation userConfirmation);

    Result update(UserConfirmation userConfirmation);

    Result delete(UserConfirmation userConfirmation);

    DataResult<List<UserConfirmation>> getAll();

    DataResult<UserConfirmation> getById(int id);

}
