package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "therapy_program")
public class TherapyProgramDto {
    @Id
    @Column (name = "therapy_id")
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String duration;
    @Column(scale = 2 ,nullable = false)
    private BigDecimal cost;
    @Column(nullable = false)
    private String description;
    @Column(name = "therapist_id" ,nullable = false)
    private String therapistId;

    public TherapyProgramDto(String id, String name, String duration, BigDecimal cost, String description, String therapistId) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.cost = cost;
        this.description = description;
        this.therapistId = therapistId;
    }
}
