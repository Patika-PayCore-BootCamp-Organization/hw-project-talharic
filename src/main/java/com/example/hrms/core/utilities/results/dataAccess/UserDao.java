package com.example.hrms.core.utilities.results.dataAccess;

import com.example.hrms.core.utilities.results.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User getByEmail(String email);

}
