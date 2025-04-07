package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.time.Year;

@Entity
@Table(name = "patient")
public class PatientDto {
    @Id
    @Column (name = "patient_id")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "phone_number" ,nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String gender;
    @Column(name = "year_of_birth" ,nullable = false)
    private Year yearOfBirth;
    @Column(name = "registration_date" ,nullable = false)
    private Date registrationDate;

    public PatientDto(String id, String name, String phoneNumber, String address, String gender, Year yearOfBirth, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
