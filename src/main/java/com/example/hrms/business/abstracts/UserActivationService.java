package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.User;
import com.example.hrms.entities.concretes.UserActivation;

import java.util.List;

public interface UserActivationService extends BaseEntityService<UserActivation> {

    DataResult<UserActivation> getByCode(String code);

    DataResult<UserActivation> getByUserId(int userId);

    DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated);

}
