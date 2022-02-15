package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobPostingConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingConfirmationDao extends JpaRepository<JobPostingConfirmation, Integer> {

}
