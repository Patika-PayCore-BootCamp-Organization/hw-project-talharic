package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EducationDao;
import com.example.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {

        educationDao.save(education);
        return new SuccessResult("Eğitim eklendi.");
    }

    @Override
    public Result update(Education education) {

        educationDao.save(education);
        return new SuccessResult("Eğitim güncellendi.");
    }

    @Override
    public Result delete(int id) {

        educationDao.deleteById(id);
        return new SuccessResult("Eğitim silindi.");
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(educationDao.findAll());
    }

    @Override
    public DataResult<Education> getById(int id) {
        return new SuccessDataResult<Education>(educationDao.getById(id));
    }

    @Override
    public DataResult<List<Education>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<Education>>(educationDao.getByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "graduationDate");

        return new SuccessDataResult<List<Education>>(educationDao.getByResume_Id(resumeId, sort));
    }

}
