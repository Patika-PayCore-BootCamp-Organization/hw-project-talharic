package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.UserActivationService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserActivationService userActivationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,	UserActivationService userActivationService) {
        this.employerDao = employerDao;
        this.userActivationService = userActivationService;
    }

    @Override
    public Result add(Employer employer) {

        if (!checkIfDomainsMatch(employer.getWebAddress(), employer.getEmail())) {
            return new ErrorResult("Web adresi ile e-posta aynı alan adına sahip olmalıdır.");
        }

        employerDao.save(employer);
        return userActivationService.add(new UserActivation(employer));
    }

    @Override
    public Result update(Employer employer) {
        employerDao.save(employer);
        return new SuccessResult();
    }

    @Override
    public Result delete(Employer employer) {
        employerDao.delete(employer);
        return new SuccessResult();
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(employerDao.findAll());
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(employerDao.getById(id));
    }

    @Override
    public Result activate(UserActivation userActivation) {

        userActivation.setActivated(true);
        userActivation.setIsActivatedDate(LocalDate.now());

        userActivationService.update(userActivation);
        return new SuccessResult("Üyeliğiniz onay aşamasındadır.");
    }

    private boolean checkIfDomainsMatch(String webAddress, String email) {

        String[] splitEmailArray = email.split("@");

        return webAddress.contains(splitEmailArray[1]);
    }

}
