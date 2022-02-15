package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.WorkingTimeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.WorkingTimeDao;
import com.example.hrms.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    private WorkingTimeDao workingTimeDao;

    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
        this.workingTimeDao = workingTimeDao;
    }

    @Override
    public Result add(WorkingTime workingTime) {

        workingTimeDao.save(workingTime);
        return new SuccessResult();
    }

    @Override
    public Result update(WorkingTime workingTime) {

        workingTimeDao.save(workingTime);
        return new SuccessResult();
    }

    @Override
    public Result delete(WorkingTime workingTime) {

        workingTimeDao.delete(workingTime);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<WorkingTime>> getAll() {
        return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll());
    }

    @Override
    public DataResult<WorkingTime> getById(int id) {
        return new SuccessDataResult<WorkingTime>(workingTimeDao.getById(id));
    }

}
