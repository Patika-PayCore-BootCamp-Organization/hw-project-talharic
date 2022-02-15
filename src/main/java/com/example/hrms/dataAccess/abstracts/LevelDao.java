package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelDao extends JpaRepository<Level, Integer> {

}
