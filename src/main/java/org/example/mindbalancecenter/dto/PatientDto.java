package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.Year;

@AllArgsConstructor
@Data
public class PatientDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String gender;
    private Year yearOfBirth;
    private Date registrationDate;
}
