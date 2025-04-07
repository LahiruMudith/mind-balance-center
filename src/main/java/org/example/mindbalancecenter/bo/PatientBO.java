package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.PatientDto;

import java.sql.SQLException;

public interface PatientBO extends SuperBO{
    boolean savePatient(PatientDto patientDto) throws SQLException, ClassNotFoundException;
}
