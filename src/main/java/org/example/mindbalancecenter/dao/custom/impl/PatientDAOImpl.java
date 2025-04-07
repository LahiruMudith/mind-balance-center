package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.dao.custom.PatientDAO;
import org.example.mindbalancecenter.entitiy.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public ArrayList<Patient> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Patient entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Patient entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Patient search(String id) throws Exception, ClassNotFoundException {
        return null;
    }
}
