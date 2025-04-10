package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Data
public class ProgramRegistrationTM {

    private String programRegistrationId;
    private Date date;
    private String patientId;
    private String programId;
}
