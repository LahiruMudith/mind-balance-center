package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.entitiy.Patient;
import org.example.mindbalancecenter.entitiy.Therapist;
import org.example.mindbalancecenter.entitiy.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class TherapyProgramDAOImpl implements TherapyProgramDAO {
    @Override
    public List<TherapyProgram> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM TherapyProgram", TherapyProgram.class).list();
    }

    @Override
    public boolean save(TherapyProgram entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            if (session != null){
                session.close();
            }
        }
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
