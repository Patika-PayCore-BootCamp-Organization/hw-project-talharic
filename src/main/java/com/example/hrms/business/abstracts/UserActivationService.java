package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.UserActivation;

public interface UserActivationService {

    Result add(UserActivation userActivation);

    Result update(UserActivation userActivation);

}
