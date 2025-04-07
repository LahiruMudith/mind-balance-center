package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class TherapyProgramDto {
    private String id;
    private String name;
    private String duration;
    private BigDecimal cost;
    private String description;
    private String therapistId;
}
