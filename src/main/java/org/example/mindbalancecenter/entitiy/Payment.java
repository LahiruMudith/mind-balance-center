package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;

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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private TherapySession sessionId;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "program_registration_id")
    private ProgramRegistration programRegistrationId;

    public Payment(String id, BigDecimal amount, Date paymentDate, TherapySession sessionId, ProgramRegistration programRegistrationId) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.sessionId = sessionId;
        this.programRegistrationId = programRegistrationId;
    }
}
