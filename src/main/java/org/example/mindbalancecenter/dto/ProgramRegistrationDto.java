package org.example.mindbalancecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class ProgramRegistrationDto {

    private String programRegistrationId;
    private Date date;
    private String patientId;
    private String programId;
    private int paymentAmount;

//    private
}
