package com.example.hrms.business.concretes;

import com.example.hrms.business.abstracts.*;
import com.example.hrms.core.utilities.results.*;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private UserService userService;
    private UserActivationService userActivationService;
    private UserConfirmationService userConfirmationService;
    private CompanyStaffService companyStaffService;
    private UpdatedEmployerService updatedEmployerService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService, UserActivationService userActivationService,
                           UserConfirmationService userConfirmationService, CompanyStaffService companyStaffService, UpdatedEmployerService updatedEmployerService) {
        this.employerDao = employerDao;
        this.userService = userService;
        this.userActivationService = userActivationService;
        this.userConfirmationService = userConfirmationService;
        this.companyStaffService = companyStaffService;
        this.updatedEmployerService = updatedEmployerService;
    }

    @Override
    public Result add(Employer employer) {

        validateEmployer(employer);

        employer.setActivated(false);
        employer.setConfirmed(false);

        employerDao.save(employer);
        return userActivationService.add(new UserActivation(employer));
    }

    @Override
    public Result update(Employer employer) {

        validateEmployer(employer);

        Employer employerInConfirmationProcess = getById(employer.getId()).getData();
        employerInConfirmationProcess.setConfirmed(false);

        UpdatedEmployer updatedEmployer = new UpdatedEmployer(
                0,
                employer.getEmail(),
                employer.getPassword(),
                employer.getCompanyName(),
                employer.getWebAddress(),
                employer.getPhoneNumber(),
                employer
        );

        updatedEmployerService.add(updatedEmployer);
        return new SuccessResult("İşveren güncellemesi onay aşamasındadır.");
    }

    @Override
    public Result delete(Employer employer) {

        employerDao.delete(employer);
        return new SuccessResult("İşveren silindi.");
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
    public Result activate(String code) {

        UserActivation userActivation = userActivationService.getByCode(code).getData();

        if (userActivation == null) {
            return new ErrorResult("Geçersiz bir kod girdiniz.");
        }

        Employer employer = getById(userActivation.getUser().getId()).getData();

        employer.setActivated(true);
        userActivation.setIsActivatedDate(LocalDateTime.now());

        employerDao.save(employer);
        userActivationService.update(userActivation);
        return new SuccessResult("Üyeliğiniz onay aşamasındadır.");
    }

    @Override
    public Result confirm(int employerId, int companyStaffId, boolean isConfirmed) {

        Employer employer = getById(employerId).getData();
        CompanyStaff companyStaff = companyStaffService.getById(companyStaffId).getData();
        UpdatedEmployer updatedEmployer = updatedEmployerService.getByEmployerId(employerId).getData();

        int numberOfUserConfirmations = userConfirmationService.getAllByUserId(employerId).getData().size();

        if (!isConfirmed && numberOfUserConfirmations == 0) {
            userActivationService.delete(userActivationService.getByUser(employer).getData());
            delete(employer);
            return new ErrorResult("İşveren onaylanmadı.");
        }

        if (isConfirmed && numberOfUserConfirmations == 0) {
            employer.setConfirmed(isConfirmed);
            employerDao.save(employer);
            userConfirmationService.add(new UserConfirmation(employer, companyStaff));
            return new SuccessResult("İşveren onaylandı.");
        }

        if (!isConfirmed && numberOfUserConfirmations > 0) {
            return new ErrorResult("İşveren onaylanmadı.");
        }

        employer.setEmail(updatedEmployer.getEmail());
        employer.setPassword(updatedEmployer.getPassword());
        employer.setCompanyName(updatedEmployer.getCompanyName());
        employer.setWebAddress(updatedEmployer.getWebAddress());
        employer.setPhoneNumber(updatedEmployer.getCompanyName());
        employer.setConfirmed(isConfirmed);

        employerDao.save(employer);
        updatedEmployerService.delete(updatedEmployer);
        userConfirmationService.add(new UserConfirmation(employer, companyStaff));
        return new SuccessResult("İşveren onaylandı.");
    }

    @Override
    public DataResult<List<Employer>> getAllByIsActivatedAndIsConfirmed(boolean isActivated, boolean isConfirmed) {
        return new SuccessDataResult<List<Employer>>(employerDao.getByIsActivatedAndIsConfirmed(isActivated, isConfirmed));
    }

    private boolean checkIfEmailExists(String email) {

        boolean result = false;

        if (userService.getByEmail(email).getData() == null) {
            result = true;
        }

        return result;
    }

    private boolean checkIfDomainsMatch(String webAddress, String email) {

        String[] splitEmailArray = email.split("@");

        return webAddress.contains(splitEmailArray[1]);
    }

    private Result validateEmployer(Employer employer) {

        if (!checkIfEmailExists(employer.getEmail())) {
            return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
        }

        if (!checkIfDomainsMatch(employer.getWebAddress(), employer.getEmail())) {
            return new ErrorResult("Web adresi ile e-posta aynı alan adına sahip olmalıdır.");
        }

        return null;
    }

}
