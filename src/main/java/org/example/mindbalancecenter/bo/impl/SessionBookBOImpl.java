package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.SessionBookBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.*;
import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.entitiy.Patient;
import org.example.mindbalancecenter.entitiy.Therapist;
import org.example.mindbalancecenter.entitiy.TherapyProgram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SessionBookBOImpl implements SessionBookBO {
    SessionBookDAO sessionBookDAO = (SessionBookDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SESSION);
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPIST);
    QuaryDAO quaryDAO = (QuaryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.QUARRY);
    @Override
    public String getNewId() throws SQLException, ClassNotFoundException {
        String lastId = sessionBookDAO.getNextId();

        if (lastId != null) {
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("S%03d", newId);
        } else {
            return "S001";
        }
    }

    @Override
    public List<PatientDto> getAllMembers() throws SQLException, ClassNotFoundException {
        List<Patient> all = patientDAO.getAll();
        List<PatientDto> patientDtos = new ArrayList<>();

        for (Patient patient : all) {
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
    public List<TherapyProgramDto> getProgramsByPatientName(String selectedPatientName) {
        return List.of();
    }

    @Override
    public PatientDto serchById(String value) throws Exception {
        Optional<Patient> patient = patientDAO.search(value);
        if (patient.isPresent()) {
            return new PatientDto(
                    patient.get().getId(),
                    patient.get().getName(),
                    patient.get().getPhoneNumber(),
                    patient.get().getAddress(),
                    patient.get().getGender(),
                    patient.get().getYearOfBirth(),
                    patient.get().getRegistrationDate()
            );
        }
        return null;
    }

    @Override
    public TherapyProgramDto searchProgramById(String selectedProgramName) throws Exception {
        Optional<TherapyProgram> therapyProgram = therapyProgramDAO.search(selectedProgramName);
        if (therapyProgram.isPresent()) {
            return new TherapyProgramDto(
                    therapyProgram.get().getId(),
                    therapyProgram.get().getName(),
                    therapyProgram.get().getDuration(),
                    therapyProgram.get().getCost(),
                    therapyProgram.get().getDescription(),
                    therapyProgram.get().getTherapistId().getName()
            );
        } else {
            return null;
        }
    }

    @Override
    public TherapistDto searchTherapistById(String therapistName) throws Exception {
        Optional<Therapist> search = Optional.ofNullable(therapistDAO.searchByName(therapistName));
        if (search.isPresent()) {
            return new TherapistDto(
                    search.get().getId(),
                    search.get().getName(),
                    search.get().getPhoneNumber(),
                    search.get().getExperienceYear(),
                    search.get().getAssignedProgram(),
                    search.get().getSpecialization()
            );
        }
        return null;
    }

    @Override
    public List<TherapyProgramDto> getAllPrograms() throws SQLException, ClassNotFoundException {
        List<TherapyProgram> all = therapyProgramDAO.getAll();
        List<TherapyProgramDto> therapyProgramDtos = new ArrayList<>();

        for (TherapyProgram therapyProgram : all) {
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
    public Long findRemainingDayCount(String patientId, String programId) {
        return quaryDAO.getRemainingDayCount(patientId, programId);
    }
}
