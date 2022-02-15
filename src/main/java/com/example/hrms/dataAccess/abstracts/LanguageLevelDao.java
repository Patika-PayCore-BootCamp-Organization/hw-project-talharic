package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer> {

}
