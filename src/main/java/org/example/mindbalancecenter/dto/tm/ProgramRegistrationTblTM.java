package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@Data
public class ProgramRegistrationTblTM {
    private String programName;
    private String duration;
    private BigDecimal cost;
    private String therapistName;
    private Date sessionDate;
}
