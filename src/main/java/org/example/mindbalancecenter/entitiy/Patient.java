package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.time.Year;

@Entity
@Table(name = "patient")
public class Patient {
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
    @Column(name = "date_of_birth" ,nullable = false)
    private Year dateOfBirth;
    @Column(name = "registration_date" ,nullable = false)
    private Date registrationDate;

    public Patient(String id, String name, String phoneNumber, String address, String gender, Year dateOfBirth, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
    }
}
