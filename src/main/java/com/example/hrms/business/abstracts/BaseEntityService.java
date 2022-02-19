package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;

import java.util.List;

public interface BaseEntityService<T> {

    Result add(T entity);

    Result update(T entity);

    Result delete(int id);

    DataResult<List<T>> getAll();

    DataResult<T> getById(int id);

}
