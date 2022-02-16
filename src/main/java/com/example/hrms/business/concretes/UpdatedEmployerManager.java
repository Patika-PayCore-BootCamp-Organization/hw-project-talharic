package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.UpdatedEmployerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UpdatedEmployerDao;
import com.example.hrms.entities.concretes.UpdatedEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdatedEmployerManager implements UpdatedEmployerService {

    private UpdatedEmployerDao updatedEmployerDao;

    @Autowired
    public UpdatedEmployerManager(UpdatedEmployerDao updatedEmployerDao) {
        this.updatedEmployerDao = updatedEmployerDao;
    }

    @Override
    public Result add(UpdatedEmployer updatedEmployer) {

        updatedEmployerDao.save(updatedEmployer);
        return new SuccessResult("Güncellenmiş işveren eklendi.");
    }

    @Override
    public Result update(UpdatedEmployer updatedEmployer) {

        updatedEmployerDao.save(updatedEmployer);
        return new SuccessResult("Güncellenmiş işveren güncellendi.");
    }

    @Override
    public Result delete(UpdatedEmployer updatedEmployer) {

        updatedEmployerDao.delete(updatedEmployer);
        return new SuccessResult("Güncellenmiş işveren silindi.");
    }

    @Override
    public DataResult<List<UpdatedEmployer>> getAll() {
        return new SuccessDataResult<List<UpdatedEmployer>>(updatedEmployerDao.findAll());
    }

    @Override
    public DataResult<UpdatedEmployer> getById(int id) {
        return new SuccessDataResult<UpdatedEmployer>(updatedEmployerDao.getById(id));
    }

    @Override
    public DataResult<UpdatedEmployer> getByEmployerId(int employerId) {
        return new SuccessDataResult<UpdatedEmployer>(updatedEmployerDao.getByEmployer_Id(employerId));
    }

}
