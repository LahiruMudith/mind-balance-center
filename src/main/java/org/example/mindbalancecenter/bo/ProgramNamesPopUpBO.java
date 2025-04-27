package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.TherapyProgramDto;

import java.sql.SQLException;
import java.util.List;

public interface ProgramNamesPopUpBO extends SuperBO{
    List<TherapyProgramDto> getProgramNames(String selectedPatientName) throws SQLException, ClassNotFoundException;
}
