package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingWithEmployerAndJobTitleDto {

    private int id;

    private String companyName;

    private String title;

    private int numberOfOpenPositions;

    private LocalDateTime postingDate;

    private LocalDate closingDate;

    private boolean isActive;

}
