package com.example.hrms.core.dataAccess;

import com.example.hrms.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User getByEmail(String email);

}
