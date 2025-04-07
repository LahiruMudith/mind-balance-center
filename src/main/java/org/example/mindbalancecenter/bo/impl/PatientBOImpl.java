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
    public boolean savePatient(PatientDto patientDto) throws SQLException, ClassNotFoundException {
        System.out.println(patientDto.toString());
        System.out.println("come to bo");
        boolean save = patientDAO.save(new Patient(
                patientDto.getId(),
                patientDto.getName(),
                patientDto.getPhoneNumber(),
                patientDto.getAddress(),
                patientDto.getGender(),
                patientDto.getYearOfBirth(),
                patientDto.getRegistrationDate()
        ));
        System.out.println(save);
        return save;
    }
}
