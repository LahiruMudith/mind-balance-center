package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "therapy_program")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TherapyProgram {
    @Id
    @Column (name = "program_id")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String duration;
    @Column(scale = 2 ,nullable = false)
    private BigDecimal cost;
    @Column(nullable = false)
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "therapist_id" ,nullable = false)
    private Therapist therapistId;
    @OneToMany(mappedBy = "programId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProgramRegistration> programRegistration;
    @OneToMany(mappedBy = "programId",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TherapySession> therapySessions;
}
