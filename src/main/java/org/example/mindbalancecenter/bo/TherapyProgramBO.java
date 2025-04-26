package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;

import java.sql.SQLException;
import java.util.List;

public interface TherapyProgramBO extends SuperBO{
    boolean save(TherapyProgramDto therapyProgramDto) throws Exception;

    List<TherapyProgramDto> getAll() throws SQLException, ClassNotFoundException;

    boolean delete(String text) throws SQLException, ClassNotFoundException;

    boolean update(TherapyProgramDto therapyProgramDto) throws Exception;

    List<TherapistDto> getTherapist() throws SQLException, ClassNotFoundException;

    String getNewId() throws SQLException, ClassNotFoundException;
}
