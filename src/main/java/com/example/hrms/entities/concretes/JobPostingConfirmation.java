package com.example.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "job_posting_confirmations")
public class JobPostingConfirmation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "is_confirmed_date")
    private LocalDateTime isConfirmedDate;

    @OneToOne()
    @JoinColumn(name = "job_posting_id")
    private JobPosting jobPosting;

    @ManyToOne()
    @JoinColumn(name = "company_staff_id")
    private CompanyStaff companyStaff;

    @ManyToOne()
    @JoinColumn(name = "job_posting_confirmation_type_id")
    private JobPostingConfirmationType jobPostingConfirmationType;

    public JobPostingConfirmation(JobPosting jobPosting, CompanyStaff companyStaff, JobPostingConfirmationType jobPostingConfirmationType, boolean isConfirmed) {
        this.setJobPosting(jobPosting);
        this.setCompanyStaff(companyStaff);
        this.setJobPostingConfirmationType(jobPostingConfirmationType);
        this.setConfirmed(isConfirmed);
    }

}
