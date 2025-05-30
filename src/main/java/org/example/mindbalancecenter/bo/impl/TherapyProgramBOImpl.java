package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.TherapyProgramBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.dto.TherapistDto;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.entitiy.Therapist;
import org.example.mindbalancecenter.entitiy.TherapyProgram;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TherapyProgramBOImpl implements TherapyProgramBO {
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPIST);

    @Override
    public boolean save(TherapyProgramDto therapyProgramDto) throws Exception {
        Therapist therapist = therapistDAO.searchByName(therapyProgramDto.getTherapistName());

        return therapyProgramDAO.save(new TherapyProgram(
                therapyProgramDto.getId(),
                therapyProgramDto.getName(),
                therapyProgramDto.getDuration(),
                therapyProgramDto.getCost(),
                therapyProgramDto.getDescription(),
                therapist
        ));
    }

    @Override
    public List<TherapyProgramDto> getAll() throws SQLException, ClassNotFoundException {
        List<TherapyProgramDto> therapyProgramDto = new ArrayList<>();
        List<TherapyProgram> therapyProgramList = therapyProgramDAO.getAll();
        List<Therapist> therapistList = therapistDAO.getAll();

        for (TherapyProgram therapyProgram : therapyProgramList){
            Therapist therapist = therapyProgram.getTherapistId();

            therapyProgramDto.add(new TherapyProgramDto(
                    therapyProgram.getId(),
                    therapyProgram.getName(),
                    therapyProgram.getDuration(),
                    therapyProgram.getCost(),
                    therapyProgram.getDescription(),
                    therapist.getName()
            ));
        }
        return therapyProgramDto;
    }

    @Override
    public boolean delete(String text) throws SQLException, ClassNotFoundException {
        return therapyProgramDAO.delete(text);
    }

    @Override
    public boolean update(TherapyProgramDto therapyProgramDto) throws Exception {
        Therapist therapist = therapistDAO.searchByName(therapyProgramDto.getTherapistName());

        return therapyProgramDAO.update(new TherapyProgram(
                therapyProgramDto.getId(),
                therapyProgramDto.getName(),
                therapyProgramDto.getDuration(),
                therapyProgramDto.getCost(),
                therapyProgramDto.getDescription(),
                therapist
        ));
    }

    @Override
    public List<TherapistDto> getTherapist() throws SQLException, ClassNotFoundException {
        List<TherapistDto> therapistDtos = new ArrayList<>();
        List<Therapist> all = therapistDAO.getAll();
        for (Therapist therapist : all){
            therapistDtos.add(new TherapistDto(
                    therapist.getId(),
                    therapist.getName(),
                    therapist.getPhoneNumber(),
                    therapist.getExperienceYear(),
                    therapist.getAssignedProgram(),
                    therapist.getSpecialization()
            ));
        }
        return therapistDtos;
    }

    @Override
    public String getNewId() throws SQLException, ClassNotFoundException {
        String lastId = therapyProgramDAO.getNextId();

        if (lastId != null) {
            int newId = Integer.parseInt(lastId.substring(2)) + 1;
            return String.format("PR%03d", newId);
        } else {
            return "PR001";
        }
    }
}
