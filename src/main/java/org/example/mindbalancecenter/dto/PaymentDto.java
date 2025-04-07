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
public class PaymentDto {
    private String id;
    private BigDecimal amount;
    private Date paymentDate;
    private String sessionId;
    private String programRegistrationId;
}
