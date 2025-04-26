package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.TherapistBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.tm.TherapistTM;
import org.example.mindbalancecenter.entitiy.Therapist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TherapistBOImpl implements TherapistBO {
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPIST);
    @Override
    public boolean save(TherapistDto therapistTM) throws SQLException, ClassNotFoundException {
        return therapistDAO.save(new Therapist(
                therapistTM.getId(),
                therapistTM.getName(),
                therapistTM.getPhoneNumber(),
                therapistTM.getExperienceYear(),
                therapistTM.getAssignedProgram(),
                therapistTM.getSpecialization()
        ));
    }

    @Override
    public boolean update(TherapistTM therapistTM) throws SQLException, ClassNotFoundException {
        return therapistDAO.update(new Therapist(
                therapistTM.getId(),
                therapistTM.getName(),
                therapistTM.getPhoneNumber(),
                therapistTM.getExperienceYear(),
                therapistTM.getAssignedProgram(),
                therapistTM.getSpecialization()
        ));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return therapistDAO.delete(id);
    }

    @Override
    public List<TherapistDto> getAll() throws SQLException, ClassNotFoundException {
        List<TherapistDto> therapistDtos = new ArrayList<>();
        List<Therapist> therapists = therapistDAO.getAll();
        for (Therapist therapist : therapists) {
            String assignProgram = therapist.getAssignedProgram() == null ? "Not Assigned" : therapist.getAssignedProgram();
            therapistDtos.add(new TherapistDto(
                    therapist.getId(),
                    therapist.getName(),
                    therapist.getPhoneNumber(),
                    therapist.getExperienceYear(),
                    assignProgram,
                    therapist.getSpecialization()
            ));
        }
        return therapistDtos;
    }

    @Override
    public String getNewId() throws SQLException, ClassNotFoundException {
        String lastId =  therapistDAO.getNextId();

        if (lastId != null) {
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            return String.format("T%03d", newId);
        } else {
            return "T001";
        }
    }
}
