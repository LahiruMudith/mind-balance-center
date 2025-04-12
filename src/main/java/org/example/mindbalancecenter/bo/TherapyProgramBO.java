package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.TherapyProgramDto;

import java.sql.SQLException;
import java.util.List;

public interface TherapyProgramBO extends SuperBO{
    boolean save(TherapyProgramDto therapyProgramDto) throws Exception;

    List<TherapyProgramDto> getAll() throws SQLException, ClassNotFoundException;
}
