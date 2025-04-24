package org.example.mindbalancecenter.dao.custom;

import org.example.mindbalancecenter.dao.CrudDAO;
import org.example.mindbalancecenter.entitiy.ProgramRegistration;
import org.example.mindbalancecenter.entitiy.Therapist;
import org.hibernate.Session;

import java.util.List;

public interface ProgramRegistrationDAO extends CrudDAO<ProgramRegistration> {
    boolean saveWithPayment(Session session, ProgramRegistration entity);

    List<ProgramRegistration> getPatientsData(String id);
}
