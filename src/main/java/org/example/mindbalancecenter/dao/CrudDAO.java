package org.example.mindbalancecenter.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    List<T> getAll() throws SQLException, ClassNotFoundException;
    boolean save(T entity) throws SQLException, ClassNotFoundException;
    boolean update(T entity) throws SQLException, ClassNotFoundException;;
    boolean delete(String id) throws SQLException, ClassNotFoundException;;
    T search(String id) throws Exception, ClassNotFoundException;
}
