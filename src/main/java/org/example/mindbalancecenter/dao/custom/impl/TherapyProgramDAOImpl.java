package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.entitiy.Therapist;
import org.example.mindbalancecenter.entitiy.TherapyProgram;

import java.sql.SQLException;
import java.util.List;

public class TherapyProgramDAOImpl implements TherapyProgramDAO {
    @Override
    public List<TherapyProgram> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean save(TherapyProgram entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(TherapyProgram entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public TherapyProgram search(String id) throws Exception, ClassNotFoundException {
        return null;
    }
}
