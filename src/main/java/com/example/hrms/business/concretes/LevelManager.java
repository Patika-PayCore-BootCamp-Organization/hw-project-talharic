package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LevelService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LevelDao;
import com.example.hrms.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelManager implements LevelService {

    private LevelDao levelDao;

    @Autowired
    public LevelManager(LevelDao levelDao) {
        this.levelDao = levelDao;
    }

    @Override
    public Result add(Level level) {

        levelDao.save(level);
        return new SuccessResult();
    }

    @Override
    public Result update(Level level) {

        levelDao.save(level);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {

        levelDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<Level>> getAll() {

        Sort sort = Sort.by(Sort.Direction.ASC, "level");

        return new SuccessDataResult<List<Level>>(levelDao.findAll(sort));
    }

    @Override
    public DataResult<Level> getById(int id) {
        return new SuccessDataResult<Level>(levelDao.getById(id));
    }

}