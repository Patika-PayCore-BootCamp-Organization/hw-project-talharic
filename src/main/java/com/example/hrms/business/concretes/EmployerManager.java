package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.CompanyStaffService;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.abstracts.UserActivationService;
import com.example.hrms.business.abstracts.UserConfirmationService;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.CompanyStaff;
import com.example.hrms.entities.concretes.Employer;
import com.example.hrms.entities.concretes.UserActivation;
import com.example.hrms.entities.concretes.UserConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserActivationService userActivationService;
    private UserConfirmationService userConfirmationService;
    private CompanyStaffService companyStaffService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,	UserActivationService userActivationService, UserConfirmationService userConfirmationService, CompanyStaffService companyStaffService) {
        this.employerDao = employerDao;
        this.userActivationService = userActivationService;
        this.userConfirmationService = userConfirmationService;
        this.companyStaffService = companyStaffService;
    }

    @Override
    public Result add(Employer employer) {

        if (!checkIfDomainsMatch(employer.getWebAddress(), employer.getEmail())) {
            return new ErrorResult("Web adresi ile e-posta aynı alan adına sahip olmalıdır.");
        }

        employer.setActivated(false);
        employer.setConfirmed(false);

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
    public DataResult<List<Employer>> getByIsActivatedAndIsConfirmed(boolean isActivated, boolean isConfirmed) {
        return new SuccessDataResult<List<Employer>>(employerDao.getByIsActivatedAndIsConfirmed(isActivated, isConfirmed));
    }

    @Override
    public Result activate(String code) {

        UserActivation userActivation = userActivationService.getByCode(code).getData();

        if (userActivation == null) {
            return new ErrorResult("Geçersiz bir kod girdiniz.");
        }

        Employer employer = getById(userActivation.getUser().getId()).getData();

        employer.setActivated(true);
        userActivation.setIsActivatedDate(LocalDate.now());

        update(employer);
        userActivationService.update(userActivation);
        return new SuccessResult("Üyeliğiniz onay aşamasındadır.");
    }

    @Override
    public Result confirm(Integer employerId, Integer companyStaffId, boolean isConfirmed) {

        Employer employer =  getById(employerId).getData();
        CompanyStaff companyStaff = companyStaffService.getById(companyStaffId).getData();

        if (isConfirmed == false) {
            userActivationService.delete(userActivationService.getByUser(employer).getData());
            delete(employer);
            return new ErrorResult("Üyelik onaylanmadı.");
        }

        employer.setConfirmed(isConfirmed);

        userConfirmationService.add(new UserConfirmation(employer, companyStaff));
        return new SuccessResult("Üyelik onaylandı.");
    }

    private boolean checkIfDomainsMatch(String webAddress, String email) {

        String[] splitEmailArray = email.split("@");

        return webAddress.contains(splitEmailArray[1]);
    }

}
