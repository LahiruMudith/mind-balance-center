package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.PatientDto;

import java.sql.SQLException;
import java.util.List;

public interface PatientBO extends SuperBO{
    boolean savePatient(PatientDto patientDto) throws SQLException, ClassNotFoundException;

    boolean updatePatient(PatientDto patientDto) throws SQLException, ClassNotFoundException;

    boolean deletePatient(String text) throws SQLException, ClassNotFoundException;

    List<PatientDto> getAllPatient() throws SQLException, ClassNotFoundException;

    String getNewId() throws SQLException, ClassNotFoundException;
}
