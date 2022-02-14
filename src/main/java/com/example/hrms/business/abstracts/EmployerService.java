package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService extends BaseEntityService<Employer> {

    DataResult<List<Employer>> getByIsActivatedAndIsConfirmed(boolean isActivated, boolean isConfirmed);

    Result activate(String code);

    Result confirm(Integer employerId, Integer companyStaffId, boolean isConfirmed);

}
