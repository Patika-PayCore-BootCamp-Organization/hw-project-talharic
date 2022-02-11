package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CityDao;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {

        cityDao.save(city);
        return new SuccessResult("Şehir eklendi.");
    }

    @Override
    public Result update(City city) {

        cityDao.save(city);
        return new SuccessResult("Şehir güncellendi.");
    }

    @Override
    public Result delete(City city) {

        cityDao.delete(city);
        return new SuccessResult("Şehir silindi.");
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(cityDao.findAll());
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(cityDao.getById(id));
    }

}