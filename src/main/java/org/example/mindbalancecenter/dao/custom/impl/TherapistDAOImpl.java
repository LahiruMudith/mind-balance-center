package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.entitiy.Therapist;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TherapistDAOImpl implements TherapistDAO {
    @Override
    public List<Therapist> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        return session.createQuery("FROM Therapist", Therapist.class).list();
    }

    @Override
    public boolean save(Therapist entity) throws SQLException, ClassNotFoundException {
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
    public boolean update(Therapist entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(entity);
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
        }    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Therapist therapist = session.get(Therapist.class, id);
            session.remove(therapist);
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
    public Optional<Therapist> search(String id) throws Exception, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Therapist therapist = session.get(Therapist.class, id);
        return Optional.ofNullable(therapist);
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public Therapist searchByName(String name) throws Exception, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        String sql = String.format("SELECT * FROM therapist WHERE name = '%s'",name); //String sql = String.format("INSERT INTO product(name, cost) VALUES('%s',%s);",product.getName(), product.getCost());
        List<Therapist> list = session.createNativeQuery(sql, Therapist.class).list();

        if (!list.isEmpty()) {
            session.close();
            return list.getFirst();
        } else {
            session.close();
            return null;
        }
    }
}
