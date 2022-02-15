package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

    Resume getByCandidate_Id(int candidateId);

}
