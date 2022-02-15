package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer> {

}