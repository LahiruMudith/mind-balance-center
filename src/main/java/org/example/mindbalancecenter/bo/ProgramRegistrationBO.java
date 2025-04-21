package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.dto.ProgramRegistrationDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.entitiy.Patient;

import java.sql.SQLException;
import java.util.List;

public interface ProgramRegistrationBO extends SuperBO{
    List<TherapyProgramDto> getPrograms() throws SQLException, ClassNotFoundException;

    List<PatientDto> getPatients() throws SQLException, ClassNotFoundException;

    PatientDto searchPatientById(String id) throws Exception;

    TherapyProgramDto searchProgramById(String id) throws Exception;

    boolean register(ProgramRegistrationDto programRegistrationDto) throws Exception;
}
