package org.example.mindbalancecenter.dao.custom;

import org.example.mindbalancecenter.dao.CrudDAO;
import org.example.mindbalancecenter.entitiy.TherapySession;
import org.hibernate.Session;

public interface SessionBookDAO extends CrudDAO<TherapySession> {
    boolean saveWithSession(Session session, TherapySession therapySession);
}
