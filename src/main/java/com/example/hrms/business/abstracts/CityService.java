package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

    Result add(City city);

    Result update(City city);

    Result delete(City city);

    DataResult<List<City>> getAll();

    DataResult<City> getById(int id);

}
