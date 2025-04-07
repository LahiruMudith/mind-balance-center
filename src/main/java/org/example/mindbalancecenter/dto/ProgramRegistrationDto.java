package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "Program_registration")
public class ProgramRegistrationDto {
    @Id
    @Column (name = "program_registration_id")
    private String programRegistrationId;
    @Column(nullable = false)
    private Date date;
    @Column(name = "patient_id" ,nullable = false)
    private String patientId;
    @Column(name = "program_id" ,nullable = false)
    private String programId;
}
