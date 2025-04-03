package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column (name = "payment_id")
    private String id;
    @Column(scale = 2 ,nullable = false)
    private BigDecimal amount;
    @Column(name = "payment_date" ,nullable = false)
    private Date paymentDate;
    @Column(name = "session_id")
    private String sessionId;
    @Column(name = "program_registration_id")
    private String programRegistrationId;

    public Payment(String id, BigDecimal amount, Date paymentDate, String sessionId, String programRegistrationId) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.sessionId = sessionId;
        this.programRegistrationId = programRegistrationId;
    }
}
