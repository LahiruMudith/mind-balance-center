package org.example.mindbalancecenter.dao.custom;

import org.example.mindbalancecenter.dao.CrudDAO;
import org.example.mindbalancecenter.entitiy.ProgramRegistration;
import org.hibernate.Session;

public interface ProgramRegistrationDAO extends CrudDAO<ProgramRegistration> {
    boolean saveWithPayment(Session session, ProgramRegistration entity);
}
