package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.UserConfirmation;

import java.util.List;

public interface UserConfirmationService extends BaseEntityService<UserConfirmation> {

    DataResult<List<UserConfirmation>> getAllByUserId(int userId);

    DataResult<List<UserConfirmation>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId);

}
