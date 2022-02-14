package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;

import java.util.List;

public interface BaseEntityService<T> {

    Result add(T t);

    Result update(T t);

    Result delete(T t);

    DataResult<List<T>> getAll();

    DataResult<T> getById(int id);

}
