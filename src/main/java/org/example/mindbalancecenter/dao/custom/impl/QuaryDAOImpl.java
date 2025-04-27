package org.example.mindbalancecenter.dao.custom.impl;

import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.custom.QuaryDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class QuaryDAOImpl implements QuaryDAO {
    @Override
    public Long getRemainingDayCount(String patientId, String programId) {
        Session session = FactoryConfiguration.getInstance().getSession();

        String hql = "SELECT COUNT(ts) FROM TherapySession ts " +
                "WHERE ts.patientId.id = :patientId " +
                "AND ts.programId.id = :programId";

        Query<Long> query = session.createQuery(hql, Long.class);
        query.setParameter("patientId", patientId);
        query.setParameter("programId", programId);

        Long count = query.uniqueResult(); // or getSingleResult()

        session.close();
        return count;
    }
}
