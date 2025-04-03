package org.example.mindbalancecenter.dao;

import org.example.mindbalancecenter.bo.SuperBO;

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
            default -> {
                return null;
            }
        }
    }
}
