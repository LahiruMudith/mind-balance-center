package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @Column (name = "payment_id")
    private String id;
    @Column(scale = 2 ,nullable = false)
    private BigDecimal amount;
    @Column(name = "payment_date" ,nullable = false)
    private Date paymentDate;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private TherapySession sessionId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_registration_id")
    private ProgramRegistration programRegistrationId;
}
