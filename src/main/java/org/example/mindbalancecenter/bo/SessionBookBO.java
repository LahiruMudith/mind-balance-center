package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;

import java.sql.SQLException;
import java.util.List;

public interface SessionBookBO extends SuperBO {

    String getNewId() throws SQLException, ClassNotFoundException;

    List<PatientDto> getAllMembers() throws SQLException, ClassNotFoundException;

    List<TherapyProgramDto> getProgramsByPatientName(String selectedPatientName);

    PatientDto serchById(String value) throws Exception;

    TherapyProgramDto searchProgramById(String selectedProgramName) throws Exception;

    TherapistDto searchTherapistById(String therapistName) throws Exception;

    List<TherapyProgramDto> getAllPrograms() throws SQLException, ClassNotFoundException;

    Long findRemainingDayCount(String value, String value1);
}
