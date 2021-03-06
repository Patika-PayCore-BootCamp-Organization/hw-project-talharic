package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPostingConfirmationTypeService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostingConfirmationTypeDao;
import com.example.hrms.entities.concretes.JobPostingConfirmationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingConfirmationTypeManager implements JobPostingConfirmationTypeService {

    private JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao;

    @Autowired
    public JobPostingConfirmationTypeManager(JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao) {
        this.jobPostingConfirmationTypeDao = jobPostingConfirmationTypeDao;
    }

    @Override
    public Result add(JobPostingConfirmationType entity) {
        return new SuccessResult("İş ilanı onay tipi eklendi.");
    }

    @Override
    public Result update(JobPostingConfirmationType entity) {
        return new SuccessResult("İş ilanı onay tipi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        return new SuccessResult("İş ilanı onay tipi silindi.");
    }

    @Override
    public DataResult<List<JobPostingConfirmationType>> getAll() {
        return new SuccessDataResult<List<JobPostingConfirmationType>>(jobPostingConfirmationTypeDao.findAll());
    }

    @Override
    public DataResult<JobPostingConfirmationType> getById(int id) {
        return new SuccessDataResult<JobPostingConfirmationType>(jobPostingConfirmationTypeDao.getById(id));
    }

}