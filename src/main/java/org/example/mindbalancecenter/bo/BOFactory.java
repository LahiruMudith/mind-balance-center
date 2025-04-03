package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.bo.impl.PatientBOImpl;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getInstance(){
        return boFactory==null ? new BOFactory() : boFactory;
    }

    public enum BOType{
        PATIENT
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case PATIENT -> {
                return new PatientBOImpl();
            }default -> {
                return null;
            }
        }
    }
}
