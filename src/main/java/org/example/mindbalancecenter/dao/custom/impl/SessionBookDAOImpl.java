package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.SessionBookDAO;
import org.example.mindbalancecenter.entitiy.TherapySession;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SessionBookDAOImpl implements SessionBookDAO {
    @Override
    public List<TherapySession> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean save(TherapySession entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(TherapySession entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<TherapySession> search(String id) throws Exception, ClassNotFoundException {
        return Optional.empty();
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        String lastId = null;

        try {
            lastId = session
                    .createQuery("SELECT p.id FROM TherapySession p ORDER BY p.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return lastId;
    }

    @Override
    public boolean saveWithSession(Session session, TherapySession therapySession) {
        try{
            session.merge(therapySession);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
