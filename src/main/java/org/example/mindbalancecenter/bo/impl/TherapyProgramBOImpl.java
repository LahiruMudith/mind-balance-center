package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.TherapyProgramBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.entitiy.Therapist;
import org.example.mindbalancecenter.entitiy.TherapyProgram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TherapyProgramBOImpl implements TherapyProgramBO {
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPIST);

    @Override
    public boolean save(TherapyProgramDto therapyProgramDto) throws Exception {
        Therapist therapist = therapistDAO.search(therapyProgramDto.getTherapistName());

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
        List<TherapyProgram> all = therapyProgramDAO.getAll();

        for (TherapyProgram therapyProgram : all){
            Therapist therapist = therapyProgram.getTherapistId();

            therapyProgramDto.add(new TherapyProgramDto(
                    therapyProgram.getId(),
                    therapyProgram.getName(),
                    therapyProgram.getDuration(),
                    therapyProgram.getCost(),
                    therapyProgram.getDescription(),
                    therapist.getId()
            ));
        }
        return therapyProgramDto;
    }
}
