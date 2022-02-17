package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.LinkName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkNameDao extends JpaRepository<LinkName, Integer> {

}
