package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Year;
import java.util.List;

@Entity
@Table(name = "patient")
@AllArgsConstructor
@Data
@NoArgsConstructor
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
    @Column(name = "year_of_birth" ,nullable = false)
    private Year yearOfBirth;
    @Column(name = "registration_date" ,nullable = false)
    private Date registrationDate;
    @OneToMany(mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<ProgramRegistration> programRegistration;
    @OneToMany(mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<TherapySession> therapySessions;

    public Patient(String id, String name, String phoneNumber, String address, String gender, Year yearOfBirth, Date registrationDate) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.registrationDate = registrationDate;
    }
}
