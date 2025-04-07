package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.PatientBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.PatientDAO;
import org.example.mindbalancecenter.dto.PatientDto;
import org.example.mindbalancecenter.entitiy.Patient;

import java.sql.SQLException;

public class PatientBOImpl implements PatientBO {
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);

    @Override
    public void savePatient(PatientDto patientDto) throws SQLException, ClassNotFoundException {
        patientDAO.save(new Patient(
                patientDto.(),
                patientDto.getName(),
                patientDto.getAddress(),
                patientDto.getPhoneNumber(),
                patientDto.getGender(),
                patientDto.getBirthYear(),
                patientDto.getRegistrationDate()
        ));
    }
}
