package org.example.mindbalancecenter.dao;

import org.example.mindbalancecenter.bo.SuperBO;
import org.example.mindbalancecenter.dao.custom.impl.PatientDAOImpl;
import org.example.mindbalancecenter.dao.custom.impl.TherapistDAOImpl;
import org.example.mindbalancecenter.dao.custom.impl.TherapyProgramDAOImpl;

public class DAOFactory {
    public static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return daoFactory==null ? new DAOFactory() : daoFactory;
    }
    public enum DAOType{
        PATIENT, THERAPIST, THERAPY_PROGRAM
    }
    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case PATIENT -> {
                return new PatientDAOImpl();
            }
            case THERAPIST -> {
                return new TherapistDAOImpl();
            }
            case THERAPY_PROGRAM -> {
                return new TherapyProgramDAOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
