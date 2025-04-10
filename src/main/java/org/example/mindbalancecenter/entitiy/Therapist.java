package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "therapist")
@AllArgsConstructor
@NoArgsConstructor
@Data
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
    @OneToOne(mappedBy = "therapistId", cascade = CascadeType.ALL)
    private TherapyProgram therapyProgram;
}
