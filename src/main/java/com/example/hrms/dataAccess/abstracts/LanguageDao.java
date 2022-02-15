package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
