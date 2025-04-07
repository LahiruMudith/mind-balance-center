package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "therapist")
public class Therapist {
    @Id
    @Column (name = "therapist_id")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(name = "phone_number" ,nullable = false)
    private String phoneNumber;
    @Column(name = "experience_year" ,nullable = false)
    private String experienceYear;
    @Column(name ="assigned_program" ,nullable = false)
    private String assignedProgram;
    @Column(nullable = false)
    private String specialization;
    @OneToMany(mappedBy = "therapistId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TherapySession> therapySessions;
    @OneToOne(mappedBy = "therapistId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TherapyProgram therapyProgram;

    public Therapist(String id, String name, String phoneNumber, String experienceYear, String assignedProgram, String specialization) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.experienceYear = experienceYear;
        this.assignedProgram = assignedProgram;
        this.specialization = specialization;
    }
}
