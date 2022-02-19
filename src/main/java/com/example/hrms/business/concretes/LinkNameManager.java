package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LinkNameService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LinkNameDao;
import com.example.hrms.entities.concretes.LinkName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkNameManager implements LinkNameService {

    private LinkNameDao linkNameDao;

    @Autowired
    public LinkNameManager(LinkNameDao linkNameDao) {
        this.linkNameDao = linkNameDao;
    }

    @Override
    public Result add(LinkName linkName) {

        linkNameDao.save(linkName);
        return new SuccessResult("Bağlantı adı eklendi.");
    }

    @Override
    public Result update(LinkName linkName) {

        linkNameDao.save(linkName);
        return new SuccessResult("Bağlantı adı güncellendi.");
    }

    @Override
    public Result delete(int id) {

        linkNameDao.deleteById(id);
        return new SuccessResult("Bağlantı adı silindi.");
    }

    @Override
    public DataResult<List<LinkName>> getAll() {
        return new SuccessDataResult<List<LinkName>>(linkNameDao.findAll());
    }

    @Override
    public DataResult<LinkName> getById(int id) {
        return new SuccessDataResult<LinkName>(linkNameDao.getById(id));
    }

}
