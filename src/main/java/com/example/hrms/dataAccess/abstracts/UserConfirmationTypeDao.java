package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.UserConfirmationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfirmationTypeDao extends JpaRepository<UserConfirmationType, Integer> {

}