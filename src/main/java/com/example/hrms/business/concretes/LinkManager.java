package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.LinkService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.LinkDao;
import com.example.hrms.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public Result add(Link link) {

        linkDao.save(link);
        return new SuccessResult("Link eklendi.");
    }

    @Override
    public Result update(Link link) {

        linkDao.save(link);
        return new SuccessResult("Link güncellendi.");
    }

    @Override
    public Result delete(int id) {

        linkDao.deleteById(id);
        return new SuccessResult("Link silindi.");
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>(linkDao.findAll());
    }

    @Override
    public DataResult<Link> getById(int id) {
        return new SuccessDataResult<Link>(linkDao.getById(id));
    }

}
