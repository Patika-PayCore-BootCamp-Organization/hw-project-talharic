package com.example.hrms.business.adapters;

import java.time.LocalDate;

public interface UserCheckService {

    boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, int yearOfBirth);

}
