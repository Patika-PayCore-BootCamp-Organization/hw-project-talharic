package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobPostingDao;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPostingDao jobPostingDao;

    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public Result add(JobPosting jobPosting) {

        jobPosting.setPostingDate(LocalDate.now());
        jobPosting.setActive(false);

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
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetails() {
        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(jobPostingDao.getJobPostingWithEmployerAndJobTitleDtoByIsActive(true));
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetailsSortedByPostingDate() {

        Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");

        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(jobPostingDao.getJobPostingWithEmployerAndJobTitleDtoByIsActive(true, sort));
    }

    @Override
    public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingDetailsByCompanyName(String companyName) {
        return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(jobPostingDao.getJobPostingWithEmployerAndJobTitleDtoByIsActiveAndCompanyName(true, companyName));
    }

    @Override
    public Result doActiveOrPassive(int id, boolean isActive) {

        String statusMessage;

        if (isActive) {
            statusMessage = "İlan aktifleştirildi.";
        } else {
            statusMessage = "İlan pasifleştirildi.";
        }

        JobPosting jobPosting = getById(id).getData();
        jobPosting.setActive(isActive);

        update(jobPosting);
        return new SuccessResult(statusMessage);
    }

}