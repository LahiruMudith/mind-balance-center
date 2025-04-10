package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TherapistTM {
    private String id;
    private String name;
    private String phoneNumber;
    private String experienceYear;
    private String assignedProgram;
    private String specialization;
}
