package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobPostingConfirmationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingConfirmationTypeDao extends JpaRepository<JobPostingConfirmationType, Integer> {

}
