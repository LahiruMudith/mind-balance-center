package org.example.mindbalancecenter.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.Year;

@Entity
@Table(name = "therapy_session")
public class TherapySession {
    @Id
    @Column (name = "session_id")
    private String id;
    @Column(name = "patient_id" ,nullable = false)
    private String patientId;
    @Column(name = "phone_number" ,nullable = false)
    private String phoneNumber;
    @Column(name = "session_duration" ,nullable = false)
    private String sessionDuration;
    @Column(name = "session_date" ,nullable = false)
    private Date sessionDate;
    @Column(name = "place_date" ,nullable = false)
    private Date placeDate;
    @Column(name = "therapist_id" ,nullable = false)
    private String therapistId;
    @Column(name = "program_id" ,nullable = false)
    private String programId;
    @Column(scale = 2 ,nullable = false)
    private BigDecimal payment;
    @Column(name = "total_remaining_amount", scale = 2 ,nullable = false)
    private BigDecimal totalRemainingAmount;
    @Column(name = "payment_status" ,nullable = false)
    private boolean paymentStatus;

    public TherapySession(String id, String patientId, String phoneNumber, String sessionDuration, Date sessionDate, Date placeDate, String therapistId, String programId, BigDecimal payment, BigDecimal totalRemainingAmount, boolean paymentStatus) {
        this.id = id;
        this.patientId = patientId;
        this.phoneNumber = phoneNumber;
        this.sessionDuration = sessionDuration;
        this.sessionDate = sessionDate;
        this.placeDate = placeDate;
        this.therapistId = therapistId;
        this.programId = programId;
        this.payment = payment;
        this.totalRemainingAmount = totalRemainingAmount;
        this.paymentStatus = paymentStatus;
    }
}
