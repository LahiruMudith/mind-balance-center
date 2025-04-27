package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.UserDAO;
import org.example.mindbalancecenter.entitiy.Patient;
import org.example.mindbalancecenter.entitiy.User;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<User> search(String id) throws Exception, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        User user = session.get(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public String getNextId() throws SQLException, ClassNotFoundException {
        return "";
    }
}
