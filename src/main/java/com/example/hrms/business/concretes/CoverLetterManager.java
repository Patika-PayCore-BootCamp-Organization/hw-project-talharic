package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CoverLetterService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CoverLetterDao;
import com.example.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverLetterManager implements CoverLetterService {

    private CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao) {
        this.coverLetterDao = coverLetterDao;
    }

    @Override
    public Result add(CoverLetter coverLetter) {

        coverLetterDao.save(coverLetter);
        return new SuccessResult("Ön yazı eklendi.");
    }

    @Override
    public Result update(CoverLetter coverLetter) {

        coverLetterDao.save(coverLetter);
        return new SuccessResult("Ön yazı güncellendi.");
    }

    @Override
    public Result delete(CoverLetter coverLetter) {

        coverLetterDao.delete(coverLetter);
        return new SuccessResult("Ön yazı silindi.");
    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<List<CoverLetter>>(coverLetterDao.findAll());
    }

    @Override
    public DataResult<CoverLetter> getById(int id) {
        return new SuccessDataResult<CoverLetter>(coverLetterDao.getById(id));
    }

}