package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.CompanyStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyStaffDao extends JpaRepository<CompanyStaff, Integer> {
}
