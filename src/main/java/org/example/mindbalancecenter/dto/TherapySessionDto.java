package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Data
public class TherapySessionDto {
    private String id;
    private String patientId;
    private String phoneNumber;
    private String sessionDuration;
    private Date sessionDate;
    private Date placeDate;
    private String therapistName;
    private String programId;
    private BigDecimal payment;
    private BigDecimal totalRemainingAmount;
    private boolean paymentStatus;
}
