package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.UserActivation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActivationDao extends JpaRepository<UserActivation, Integer> {
}