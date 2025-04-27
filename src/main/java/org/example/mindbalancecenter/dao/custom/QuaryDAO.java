package org.example.mindbalancecenter.dao.custom;

import org.example.mindbalancecenter.dao.SuperDAO;

public interface QuaryDAO extends SuperDAO {
    Long getRemainingDayCount(String patientId, String programId);
}
