package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.entitiy.Therapist;

import java.sql.SQLException;
import java.util.List;

public class TherapistDAOImpl implements TherapistDAO {
    @Override
    public List<Therapist> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean save(Therapist entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Therapist entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Therapist search(String id) throws Exception, ClassNotFoundException {
        return null;
    }
}
