package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.entitiy.TherapyProgram;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            TherapyProgram therapyProgram = session.get(TherapyProgram.class, id);
            session.remove(therapyProgram);
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
    public Optional<TherapyProgram> search(String id) throws Exception, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        TherapyProgram therapyProgram = session.get(TherapyProgram.class, id);
        return Optional.ofNullable(therapyProgram);
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        String lastId = null;

        try {
            lastId = session
                    .createQuery("SELECT pr.id FROM TherapyProgram pr ORDER BY pr.id DESC", String.class)
                    .setMaxResults(1)
                    .uniqueResult();
        } finally {
            session.close();
        }
        return lastId;
    }

    @Override
    public TherapyProgram searchByName(String name) {
        Session session = FactoryConfiguration.getInstance().getSession();
        String sql = String.format("SELECT * FROM therapy_program WHERE name = '%s'",name); //String sql = String.format("INSERT INTO product(name, cost) VALUES('%s',%s);",product.getName(), product.getCost());
        List<TherapyProgram> list = session.createNativeQuery(sql, TherapyProgram.class).list();

        if (!list.isEmpty()) {
            session.close();
            return list.getFirst();
        } else {
            session.close();
            return null;
        }
    }
}
