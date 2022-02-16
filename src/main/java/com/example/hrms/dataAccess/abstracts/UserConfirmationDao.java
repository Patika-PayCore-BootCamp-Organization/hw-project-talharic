package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.UserConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserConfirmationDao extends JpaRepository<UserConfirmation, Integer> {

    List<UserConfirmation> getByUser_Id(int userId);

}