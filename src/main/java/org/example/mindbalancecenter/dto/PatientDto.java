package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;
import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String gender;
    private Year yearOfBirth;
    private Date registrationDate;

    private int age;

    public PatientDto(String id, String name, String phoneNumber, String address, String gender, Year yearOfBirth, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.registrationDate = registrationDate;
    }
}
