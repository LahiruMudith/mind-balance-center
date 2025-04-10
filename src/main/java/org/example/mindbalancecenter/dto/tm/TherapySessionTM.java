package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Data
public class TherapySessionTM {
    private String id;
    private String patientId;
    private String phoneNumber;
    private String sessionDuration;
    private Date sessionDate;
    private Date placeDate;
    private String therapistId;
    private String programId;
    private BigDecimal payment;
    private BigDecimal totalRemainingAmount;
    private boolean paymentStatus;
}
