package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

    List<Employer> getByIsActivatedAndIsConfirmed(boolean isActivated, boolean isConfirmed);

}
