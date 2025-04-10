package org.example.mindbalancecenter.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.Year;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientTM {
    private String id;
    private String name;
    private String phoneNumber;
    private String address;
    private String gender;
    private Year yearOfBirth;
    private Date registrationDate;
}
