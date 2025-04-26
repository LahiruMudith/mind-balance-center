package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Program_registration")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgramRegistration {
    @Id
    @Column (name = "program_registration_id")
    private String id;
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
