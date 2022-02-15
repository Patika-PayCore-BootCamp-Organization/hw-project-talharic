package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LanguageLevelService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LanguageLevelDao;
import com.example.hrms.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageLevelManager implements LanguageLevelService {

    private LanguageLevelDao languageLevelDao;

    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
        this.languageLevelDao = languageLevelDao;
    }

    @Override
    public Result add(LanguageLevel languageLevel) {

        languageLevelDao.save(languageLevel);
        return new SuccessResult("Dil seviyesi eklendi.");
    }

    @Override
    public Result update(LanguageLevel languageLevel) {

        languageLevelDao.save(languageLevel);
        return new SuccessResult("Dil seviyesi güncellendi.");
    }

    @Override
    public Result delete(LanguageLevel languageLevel) {

        languageLevelDao.delete(languageLevel);
        return new SuccessResult("Dil seviyesi silindi.");
    }

    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>(languageLevelDao.findAll());
    }

    @Override
    public DataResult<LanguageLevel> getById(int id) {
        return new SuccessDataResult<LanguageLevel>(languageLevelDao.getById(id));
    }

}
