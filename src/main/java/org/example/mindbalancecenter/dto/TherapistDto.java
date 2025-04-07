package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TherapistDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String experienceYear;
    private String assignedProgram;
    private String specialization;
}
