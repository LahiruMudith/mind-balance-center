package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.PatientDAO;
import org.example.mindbalancecenter.entitiy.Patient;
import org.example.mindbalancecenter.exeception.DuplicateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public List<Patient> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Patient", Patient.class).list();
    }

    @Override
    public boolean save(Patient entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Patient patient = session.get(Patient.class, entity.getId());
            if (patient != null){
                throw new DuplicateException("Patient already exists");
            }

            session.persist(entity);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Patient entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(entity);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Patient patient = session.get(Patient.class, id);
            session.remove(patient);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Patient search(String id) throws Exception, ClassNotFoundException {
        return null;
    }
}
