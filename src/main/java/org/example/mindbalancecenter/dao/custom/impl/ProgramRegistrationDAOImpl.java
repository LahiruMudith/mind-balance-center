package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.dao.custom.ProgramRegistrationDAO;
import org.example.mindbalancecenter.entitiy.ProgramRegistration;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ProgramRegistrationDAOImpl implements ProgramRegistrationDAO {
    @Override
    public List<ProgramRegistration> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean save(ProgramRegistration entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(ProgramRegistration entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ProgramRegistration search(String id) throws Exception, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveWithPayment(Session session, ProgramRegistration entity) {
        try {
            session.merge(entity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
