package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UserConfirmation;

public interface UserConfirmationService {
    Result add(UserConfirmation userConfirmation);
}
