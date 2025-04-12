package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.tm.TherapistTM;

import java.sql.SQLException;
import java.util.List;

public interface TherapistBO extends SuperBO{
    boolean save(TherapistTM therapistTM) throws SQLException, ClassNotFoundException;

    boolean update(TherapistTM therapistTM) throws SQLException, ClassNotFoundException;

    boolean delete(String id) throws SQLException, ClassNotFoundException;

    List<TherapistDto> getAll() throws SQLException, ClassNotFoundException;
}
