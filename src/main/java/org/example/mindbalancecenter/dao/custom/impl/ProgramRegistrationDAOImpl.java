package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.ProgramRegistrationDAO;
import org.example.mindbalancecenter.entitiy.ProgramRegistration;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    public Optional<ProgramRegistration> search(String id) throws Exception, ClassNotFoundException {
        return Optional.empty();
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        String lastId = null;

        try {
            lastId = session
                    .createQuery("SELECT p.id FROM ProgramRegistration p ORDER BY p.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return lastId;
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

    @Override
    public List<ProgramRegistration> getPatientsData(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        String sql = String.format("SELECT * FROM program_registration WHERE patient_id = '%s'",id);
        return session.createNativeQuery(sql, ProgramRegistration.class).list();
    }
}
