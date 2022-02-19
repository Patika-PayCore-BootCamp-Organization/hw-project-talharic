package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.WorkingTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.WorkingTypeDao;
import com.example.hrms.entities.concretes.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTypeManager implements WorkingTypeService {

    private WorkingTypeDao workingTypeDao;

    @Autowired
    public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
        this.workingTypeDao = workingTypeDao;
    }

    @Override
    public Result add(WorkingType workingType) {

        workingTypeDao.save(workingType);
        return new SuccessResult();
    }

    @Override
    public Result update(WorkingType workingType) {

        workingTypeDao.save(workingType);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {

        workingTypeDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<WorkingType>> getAll() {
        return new SuccessDataResult<List<WorkingType>>(workingTypeDao.findAll());
    }

    @Override
    public DataResult<WorkingType> getById(int id) {
        return new SuccessDataResult<WorkingType>(workingTypeDao.getById(id));
    }

}
