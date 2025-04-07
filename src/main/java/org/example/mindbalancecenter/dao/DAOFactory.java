package org.example.mindbalancecenter.dao;

import org.example.mindbalancecenter.bo.SuperBO;
import org.example.mindbalancecenter.dao.custom.impl.PatientDAOImpl;

public class DAOFactory {
    public static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return daoFactory==null ? new DAOFactory() : daoFactory;
    }
    public enum DAOType{
        PATIENT
    }
    public SuperDAO getDAO(DAOType daoType){
        switch (daoType){
            case PATIENT -> {
                return new PatientDAOImpl();
            }
            default -> {
                return null;
            }
        }
    }
}
