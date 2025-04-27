package org.example.mindbalancecenter.bo;

import org.example.mindbalancecenter.bo.impl.*;

public class BOFactory {
    public static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getInstance(){
        return boFactory==null ? new BOFactory() : boFactory;
    }

    public enum BOType{
    PATIENT, THERAPIST, THERAPY_PROGRAM, PROGRAM_REGISTRATION, USER, SESSION, PROGRAM_POPUP_MENU
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case PATIENT -> {
                return new PatientBOImpl();
            }case THERAPIST -> {
                return new TherapistBOImpl();
            }case THERAPY_PROGRAM -> {
                return new TherapyProgramBOImpl();
            }case PROGRAM_REGISTRATION -> {
                return new ProgramRegistrationBOImpl();
            }case USER -> {
                return new UserBOImpl();
            }case SESSION -> {
                return new SessionBookBOImpl();
            }case PROGRAM_POPUP_MENU -> {
                return new ProgramNamesPopUpBOImpl();
            }default -> {
                return null;
            }
        }
    }
}
