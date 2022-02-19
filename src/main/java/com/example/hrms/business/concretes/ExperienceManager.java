package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.ExperienceService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ExperienceDao;
import com.example.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public Result add(Experience experience) {

        experienceDao.save(experience);
        return new SuccessResult("İş deneyimi eklendi.");
    }

    @Override
    public Result update(Experience experience) {

        experienceDao.save(experience);
        return new SuccessResult("İş deneyimi güncellendi.");
    }

    @Override
    public Result delete(int id) {

        experienceDao.deleteById(id);
        return new SuccessResult("İş deneyimi silindi.");
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(experienceDao.findAll());
    }

    @Override
    public DataResult<Experience> getById(int id) {
        return new SuccessDataResult<Experience>(experienceDao.getById(id));
    }

    @Override
    public DataResult<List<Experience>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<Experience>>(experienceDao.getByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "terminationDate");

        return new SuccessDataResult<List<Experience>>(experienceDao.getByResume_Id(resumeId, sort));
    }

}
