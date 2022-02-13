package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostingDao;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobTitleDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPostingDao jobPostingDao;

    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public Result add(JobPosting jobPosting) {

        jobPostingDao.save(jobPosting);
        return new SuccessResult("İş ilanı eklendi.");
    }

    @Override
    public Result update(JobPosting jobPosting) {

        jobPostingDao.save(jobPosting);
        return new SuccessResult("İş ilanı güncellendi.");
    }

    @Override
    public Result delete(JobPosting jobPosting) {

        jobPostingDao.delete(jobPosting);
        return new SuccessResult("İş ilanı silindi.");
    }

    @Override
    public DataResult<List<JobPosting>> getAll() {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll());
    }

    @Override
    public DataResult<JobPosting> getById(int id) {
        return new SuccessDataResult<JobPosting>(jobPostingDao.getById(id));
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getActiveJobPostingDetails() {
        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(jobPostingDao.getJobPostingWithEmployerAndJobTitleDetailsByIsActive(true));
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getActiveJobPostingDetailsSortedByPostingDate() {

        Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");

        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(jobPostingDao.getJobPostingWithEmployerAndJobTitleDetailsByIsActive(true, sort));
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getActiveJobPostingDetailsByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(jobPostingDao.getJobPostingWithEmployerAndJobTitleDetailsByIsActiveAndEmployer_EmployerId(true, employerId));
    }

}