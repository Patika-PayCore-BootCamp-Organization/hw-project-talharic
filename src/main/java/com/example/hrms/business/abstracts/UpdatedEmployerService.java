package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.entities.concretes.UpdatedEmployer;

public interface UpdatedEmployerService extends BaseEntityService<UpdatedEmployer> {

    DataResult<UpdatedEmployer> getByEmployerId(int employerId);

}
