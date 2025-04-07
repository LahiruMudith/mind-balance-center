package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Program_registration")
public class ProgramRegistration {
    @Id
    @Column (name = "program_registration_id")
    private String programRegistrationId;
    @Column(nullable = false)
    private Date date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patientId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "program_id" ,nullable = false)
    private TherapyProgram programId;;
    @OneToOne(mappedBy = "programRegistrationId", cascade = CascadeType.ALL)
    private Payment payment;

}
