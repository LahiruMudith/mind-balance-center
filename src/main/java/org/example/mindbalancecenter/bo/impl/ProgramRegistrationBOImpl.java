package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.ProgramRegistrationBO;
import org.example.mindbalancecenter.config.FactoryConfiguration;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.PatientDAO;
import org.example.mindbalancecenter.dao.custom.PaymentDAO;
import org.example.mindbalancecenter.dao.custom.ProgramRegistrationDAO;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.dto.ProgramRegistrationDto;
import org.example.mindbalancecenter.dto.ProgramRegistrationTblDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.entitiy.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgramRegistrationBOImpl implements ProgramRegistrationBO {
    ProgramRegistrationDAO programRegistrationDAO = (ProgramRegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM_REGISTRATION);
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PAYMENT);
    @Override
    public List<TherapyProgramDto> getPrograms() throws SQLException, ClassNotFoundException {
        List<TherapyProgramDto> therapyProgramDtos = new ArrayList<>();
        List<TherapyProgram> therapyPrograms = therapyProgramDAO.getAll();

        for (TherapyProgram therapyProgram : therapyPrograms) {
            therapyProgramDtos.add(new TherapyProgramDto(
                    therapyProgram.getId(),
                    therapyProgram.getName(),
                    therapyProgram.getDuration(),
                    therapyProgram.getCost(),
                    therapyProgram.getDescription(),
                    therapyProgram.getTherapistId().getName()
            ));
        }
        return therapyProgramDtos;
    }

    @Override
    public List<PatientDto> getPatients() throws SQLException, ClassNotFoundException {
        List<PatientDto> patientDtos = new ArrayList<>();
        List<Patient> patients = patientDAO.getAll();

        for (Patient patient : patients) {
            patientDtos.add(new PatientDto(
                    patient.getId(),
                    patient.getName(),
                    patient.getPhoneNumber(),
                    patient.getAddress(),
                    patient.getGender(),
                    patient.getYearOfBirth(),
                    patient.getRegistrationDate()
            ));
        }
        return patientDtos;
    }

    @Override
    public PatientDto searchPatientById(String id) throws Exception {
        Optional<Patient> patient = patientDAO.search(id);
        int thisYear = Year.now().getValue();
        int  patientYear = patient.get().getYearOfBirth().getValue();
        int age = thisYear - patientYear;
        System.out.println(age);
        return new PatientDto(
                patient.get().getId(),
                patient.get().getName(),
                patient.get().getPhoneNumber(),
                patient.get().getAddress(),
                patient.get().getGender(),
                patient.get().getYearOfBirth(),
                patient.get().getRegistrationDate(),
                age
        );
    }

    @Override
    public TherapyProgramDto searchProgramById(String id) throws Exception {
        Optional<TherapyProgram> therapyProgram = therapyProgramDAO.search(id);
        Therapist therapist = therapyProgram.get().getTherapistId();
        return new TherapyProgramDto(
                therapyProgram.get().getId(),
                therapyProgram.get().getName(),
                therapyProgram.get().getDuration(),
                therapyProgram.get().getCost(),
                therapyProgram.get().getDescription(),
                therapist.getName(),
                therapist.getSpecialization(),
                therapist.getExperienceYear()
        );
    }

    @Override
    public boolean register(ProgramRegistrationDto programRegistrationDto) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Optional<Patient> searchPatient = patientDAO.search(programRegistrationDto.getPatientId());
            if (searchPatient.isEmpty()){
                transaction.rollback();
                return false;
            }

            Optional<TherapyProgram> searchProgram = therapyProgramDAO.search(programRegistrationDto.getProgramId());
            if (searchProgram.isEmpty()){
                transaction.rollback();
                return false;
            }

            Payment payment = new Payment();
            ProgramRegistration programRegistration = new ProgramRegistration();
            programRegistration.setProgramRegistrationId(programRegistrationDto.getProgramId());
            programRegistration.setDate(programRegistrationDto.getDate());
            programRegistration.setProgramId(searchProgram.get());
            programRegistration.setPatientId(searchPatient.get());

            payment.setId("001");
            payment.setAmount(BigDecimal.valueOf(programRegistrationDto.getPaymentAmount()));
            payment.setPaymentDate(programRegistrationDto.getDate());
            payment.setSessionId(null);
            payment.setProgramRegistrationId(programRegistration);
//            programRegistration.setPayment(payment);

            boolean isSavedProgramRegistration = programRegistrationDAO.saveWithPayment(session, programRegistration);
            if (!isSavedProgramRegistration){
                transaction.rollback();
                return false;
            }

            boolean isSavedPayment = paymentDAO.saveWithProgramRegistration(session, payment);
            if (!isSavedPayment){
                transaction.rollback();
                return false;
            }
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<ProgramRegistrationTblDto> getTblData(String id) {
        List<ProgramRegistrationTblDto> programRegistrationTblDtos = new ArrayList<>();
        List<ProgramRegistration> patientsData = programRegistrationDAO.getPatientsData(id);
        for (ProgramRegistration programRegistration : patientsData){
            TherapyProgram program = programRegistration.getProgramId();
            Therapist therapist = program.getTherapistId();
            Date date = Date.valueOf(LocalDate.now());


            programRegistrationTblDtos.add(
                    new ProgramRegistrationTblDto(
                            program.getName(),
                            program.getDuration(),
                            program.getCost(),
                            therapist.getName(),
                            date
                    )
            );
        }
        return programRegistrationTblDtos;
    }
}
