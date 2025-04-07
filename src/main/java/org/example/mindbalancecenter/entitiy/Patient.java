package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.Year;
import java.util.List;

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
    @Column(name = "year_of_birth" ,nullable = false)
    private Year yearOfBirth;
    @Column(name = "registration_date" ,nullable = false)
    private Date registrationDate;
    @OneToMany(mappedBy = "patientId")
    private List<ProgramRegistration> programRegistration;
    @OneToMany(mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<TherapySession> therapySessions;

    public Patient(String id, String name, String phoneNumber, String address, String gender, Year yearOfBirth, Date registrationDate, List<ProgramRegistration> programRegistration, List<TherapySession> therapySessions) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.registrationDate = registrationDate;
        this.programRegistration = programRegistration;
        this.therapySessions = therapySessions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Year getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Year yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<ProgramRegistration> getProgramRegistration() {
        return programRegistration;
    }

    public void setProgramRegistration(List<ProgramRegistration> programRegistration) {
        this.programRegistration = programRegistration;
    }

    public List<TherapySession> getTherapySessions() {
        return therapySessions;
    }

    public void setTherapySessions(List<TherapySession> therapySessions) {
        this.therapySessions = therapySessions;
    }
}
