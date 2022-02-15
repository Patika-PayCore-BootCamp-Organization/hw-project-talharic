package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.JobPosting;
import com.example.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

    @Query("Select new  com.example.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobTitleDto"
            + "(jp.id, e.companyName, jt.title, jp.numberOfOpenPositions, jp.postingDate, jp.closingDate, jp.isActive)"
            + "From JobPosting jp Inner Join jp.employer e Inner Join jp.jobTitle jt Where jp.isActive=:isActive")
    List<JobPostingWithEmployerAndJobTitleDto> getJobPostingWithEmployerAndJobTitleDtoByIsActive(boolean isActive);

    @Query("Select new  com.example.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobTitleDto"
            + "(jp.id, e.companyName, jt.title, jp.numberOfOpenPositions, jp.postingDate, jp.closingDate, jp.isActive)"
            + "From JobPosting jp Inner Join jp.employer e Inner Join jp.jobTitle jt Where jp.isActive=:isActive")
    List<JobPostingWithEmployerAndJobTitleDto> getJobPostingWithEmployerAndJobTitleDtoByIsActive(boolean isActive, Sort sort);

    @Query("Select new  com.example.hrms.entities.concretes.dtos.JobPostingWithEmployerAndJobTitleDto"
            + "(jp.id, e.companyName, jt.title, jp.numberOfOpenPositions, jp.postingDate, jp.closingDate, jp.isActive)"
            + "From JobPosting jp Inner Join jp.employer e Inner Join jp.jobTitle jt Where jp.isActive=:isActive and e.companyName=:companyName")
    List<JobPostingWithEmployerAndJobTitleDto> getJobPostingWithEmployerAndJobTitleDtoByIsActiveAndCompanyName(boolean isActive, String companyName);

}
