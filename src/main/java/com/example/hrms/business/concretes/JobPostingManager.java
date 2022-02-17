package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CompanyStaffService;
import com.example.hrms.business.abstracts.JobPostingConfirmationService;
import com.example.hrms.business.abstracts.JobPostingService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.JobPostingDao;
import com.example.hrms.entities.concretes.CompanyStaff;
import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.concretes.JobPostingConfirmation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPostingDao jobPostingDao;
    private JobPostingConfirmationService jobPostingConfirmationService;
    private CompanyStaffService companyStaffService;

    public JobPostingManager(JobPostingDao jobPostingDao, JobPostingConfirmationService jobPostingConfirmationService, CompanyStaffService companyStaffService) {
        this.jobPostingDao = jobPostingDao;
        this.jobPostingConfirmationService = jobPostingConfirmationService;
        this.companyStaffService = companyStaffService;
    }

    @Override
    public Result add(JobPosting jobPosting) {

        jobPosting.setPostingDate(LocalDateTime.now());
        jobPosting.setActive(false);
        jobPosting.setConfirmed(false);

        jobPostingDao.save(jobPosting);
        return new SuccessResult("İş ilanı onay aşamasındadır.");
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
    public Result confirm(int jobPostingId, int companyStaffId, boolean isConfirmed) {

        JobPosting jobPosting = getById(jobPostingId).getData();
        CompanyStaff companyStaff = companyStaffService.getById(companyStaffId).getData();

        if (!isConfirmed) {
            delete(jobPosting);
            return new ErrorResult("İş ilanı onaylanmadı.");
        }

        jobPosting.setActive(true);
        jobPosting.setConfirmed(isConfirmed);

        jobPostingDao.save(jobPosting);
        jobPostingConfirmationService.add(new JobPostingConfirmation(jobPosting, companyStaff));
        return new SuccessResult("İş ilanı onaylandı.");
    }

    @Override
    public Result makeActiveOrPassive(int id, boolean isActive) {

        String statusMessage = isActive ? "İlan aktifleştirildi." : "İlan pasifleştirildi.";

        JobPosting jobPosting = getById(id).getData();
        jobPosting.setActive(isActive);

        update(jobPosting);
        return new SuccessResult(statusMessage);
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnes() {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(true));
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnesByPage(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(true, pageable));
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDate() {

        Sort sort = Sort.by(Sort.Direction.DESC, "postingDate");

        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(true, sort));
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnesByPageSortedByPostingDate(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by("postingDate").descending());

        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActive(true, pageable));
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDateTop6() {

        List<JobPosting> result = getAllActiveOnesByPageSortedByPostingDate(1, 6).getData();

        return new SuccessDataResult<List<JobPosting>>(result);
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnesByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByIsActiveAndEmployer_Id(true, employerId));
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(int cityId, int jobTitleId, int workingTimeId, int workingTypeId) {

        List<JobPosting> result = getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingTypeBase(cityId, jobTitleId, workingTimeId, workingTypeId);

        return new SuccessDataResult<List<JobPosting>>(result);
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(int cityId, int jobTitleId, int workingTimeId, int workingTypeId, int pageNo, int pageSize) {

        int skipCount = (pageNo -1) * pageSize;

        List<JobPosting> result = getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingTypeBase(cityId, jobTitleId, workingTimeId, workingTypeId);

        return new SuccessDataResult<List<JobPosting>>(result.stream().skip(skipCount).limit(pageSize).collect(Collectors.toList()));
    }

    private List<JobPosting> getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingTypeBase(int cityId, int jobTitleId, int workingTimeId, int workingTypeId) {

        Stream<JobPosting> stream = getAllActiveOnesSortedByPostingDate().getData().stream();

        Predicate<JobPosting> workingTimeCondition = jobPosting -> jobPosting.getWorkingTime().getId() == workingTimeId;
        Predicate<JobPosting> workingTypeCondition = jobPosting -> jobPosting.getWorkingType().getId() == workingTypeId;
        Predicate<JobPosting> cityCondition = jobPosting -> jobPosting.getCity().getId() == cityId;
        Predicate<JobPosting> jobTitleCondition = jobPosting -> jobPosting.getJobTitle().getId() == jobTitleId;

        List<JobPosting> result = new ArrayList<JobPosting>();

        if (workingTimeId == 0 && workingTypeId != 0 && cityId != 0 && jobTitleId != 0) {
            stream.filter(workingTypeCondition).filter(cityCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId == 0 && cityId != 0 && jobTitleId != 0) {
            stream.filter(workingTimeCondition).filter(cityCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId != 0 && cityId == 0 && jobTitleId != 0) {
            stream.filter(workingTimeCondition).filter(workingTypeCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId != 0 && cityId != 0 && jobTitleId == 0) {
            stream.filter(workingTimeCondition).filter(workingTypeCondition).filter(cityCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId == 0 && workingTypeId == 0 && cityId != 0 && jobTitleId != 0) {
            stream.filter(cityCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId == 0 && workingTypeId != 0 && cityId == 0 && jobTitleId != 0) {
            stream.filter(workingTypeCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId == 0 && workingTypeId != 0 && cityId != 0 && jobTitleId == 0) {
            stream.filter(workingTypeCondition).filter(cityCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId == 0 && cityId == 0 && jobTitleId != 0) {
            stream.filter(workingTimeCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId == 0 && cityId != 0 && jobTitleId == 0) {
            stream.filter(workingTimeCondition).filter(cityCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId != 0 && cityId == 0 && jobTitleId == 0) {
            stream.filter(workingTimeCondition).filter(workingTypeCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId == 0 && workingTypeId == 0 && cityId == 0 && jobTitleId != 0) {
            stream.filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId == 0 && workingTypeId == 0 && cityId != 0 && jobTitleId == 0) {
            stream.filter(cityCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId == 0 && workingTypeId != 0 && cityId == 0 && jobTitleId == 0) {
            stream.filter(workingTypeCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId == 0 && cityId == 0 && jobTitleId == 0) {
            stream.filter(workingTimeCondition).forEach(jobPosting -> result.add(jobPosting));
        } else if (workingTimeId != 0 && workingTypeId != 0 && cityId != 0 && jobTitleId != 0) {
            stream.filter(workingTimeCondition).filter(workingTypeCondition).filter(cityCondition).filter(jobTitleCondition).forEach(jobPosting -> result.add(jobPosting));
        } else {
            return getAllActiveOnesSortedByPostingDate().getData();
        }

        return result;
    }

}