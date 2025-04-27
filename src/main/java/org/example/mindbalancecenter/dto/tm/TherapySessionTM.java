package org.example.mindbalancecenter.dto.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Data
public class TherapySessionTM {
    private String id;
    private Date sessionDate;
    private BigDecimal payment;
    private boolean paymentStatus;
    private Button deleteBtn;
}
