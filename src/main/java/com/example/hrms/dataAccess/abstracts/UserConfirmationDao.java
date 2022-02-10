package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.UserConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfirmationDao extends JpaRepository<UserConfirmation, Integer> {
}
