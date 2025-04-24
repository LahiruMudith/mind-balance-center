package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.PatientDAO;
import org.example.mindbalancecenter.entitiy.Patient;
import org.example.mindbalancecenter.exeception.DuplicateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
    public Optional<Patient> search(String id) throws ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Patient patient = session.get(Patient.class, id);
        return Optional.ofNullable(patient);
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            // HQL query to get the last inserted patient ID (ordered descending)
            Query<String> query = session.createQuery("SELECT p.patient_id FROM patient p ORDER BY p.id DESC", String.class);
            query.setMaxResults(1);
            String lastId = query.uniqueResult();

            transaction.commit();
            session.close();

            if (lastId != null) {
                int lastNum = Integer.parseInt(lastId.replace("P", ""));
                int nextNum = lastNum + 1;
                return String.format("P%03d", nextNum); // Format: P001, P002, ...
            } else {
                return "P001";
            }
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            throw new RuntimeException("no patient ID", e);
        }
    }

    @Override
    public Patient searchByName(String name) {
        Session session = FactoryConfiguration.getInstance().getSession();
        String sql = String.format("SELECT * FROM patient WHERE name = '%s'",name); //String sql = String.format("INSERT INTO product(name, cost) VALUES('%s',%s);",product.getName(), product.getCost());
        List<Patient> list = session.createNativeQuery(sql, Patient.class).list();

        if (!list.isEmpty()) {
            session.close();
            return list.getFirst();
        } else {
            session.close();
            return null;
        }
    }
}
