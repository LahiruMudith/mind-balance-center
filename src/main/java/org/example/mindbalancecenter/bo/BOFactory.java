package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.bo.impl.PatientBOImpl;
import org.example.mindbalancecenter.bo.impl.TherapistBOImpl;
import org.example.mindbalancecenter.bo.impl.TherapyProgramBOImpl;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getInstance(){
        return boFactory==null ? new BOFactory() : boFactory;
    }

    public enum BOType{
        PATIENT, THERAPIST, THERAPY_PROGRAM
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case PATIENT -> {
                return new PatientBOImpl();
            }case THERAPIST -> {
                return new TherapistBOImpl();
            }case THERAPY_PROGRAM -> {
                return new TherapyProgramBOImpl();
            } default -> {
                return null;
            }
        }
    }
}
