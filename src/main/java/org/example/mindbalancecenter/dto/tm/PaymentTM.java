package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Data
public class PaymentTM {
    private String id;
    private BigDecimal amount;
    private Date paymentDate;
    private String sessionId;
    private String programRegistrationId;
}
