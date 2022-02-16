package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.UpdatedEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdatedEmployerDao extends JpaRepository<UpdatedEmployer, Integer> {

    UpdatedEmployer getByEmployer_Id(int employerId);

}
