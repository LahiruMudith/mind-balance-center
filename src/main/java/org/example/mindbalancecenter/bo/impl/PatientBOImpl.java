package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.PatientBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.PatientDAO;
import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.entitiy.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientBOImpl implements PatientBO {
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);

    @Override
    public boolean savePatient(PatientDto patientDto) throws SQLException, ClassNotFoundException {
        boolean save = patientDAO.save(new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getPhoneNumber(),
                patientDto.getAddress(),
                patientDto.getGender(),
                patientDto.getYearOfBirth(),
                patientDto.getRegistrationDate()
        ));
        return save;
    }

    @Override
    public boolean updatePatient(PatientDto patientDto) throws SQLException, ClassNotFoundException {
        return patientDAO.update(new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getPhoneNumber(),
                patientDto.getAddress(),
                patientDto.getGender(),
                patientDto.getYearOfBirth(),
                patientDto.getRegistrationDate()
        ));
    }

    @Override
    public boolean deletePatient(String id) throws SQLException, ClassNotFoundException {
        return patientDAO.delete(id);
    }

    @Override
    public List<PatientDto> getAllPatient() throws SQLException, ClassNotFoundException {
        List<PatientDto> patientDtos = new ArrayList<>();

        List<Patient> all = patientDAO.getAll();
        for (Patient patient : all){
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
        System.out.println(patientDtos);
        return patientDtos;
    }

    @Override
    public String getNewId() throws SQLException, ClassNotFoundException {
        String lastId = patientDAO.getNextId();

        if (lastId != null) {
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("P%03d", newId);
        } else {
            return "P001";
        }
    }
}
