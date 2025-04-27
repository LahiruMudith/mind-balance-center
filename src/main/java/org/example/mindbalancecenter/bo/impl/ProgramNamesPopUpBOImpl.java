package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.ProgramNamesPopUpBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.dto.TherapyProgramDto;
import org.example.mindbalancecenter.entitiy.TherapyProgram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramNamesPopUpBOImpl implements ProgramNamesPopUpBO {
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);
    @Override
    public List<TherapyProgramDto> getProgramNames(String selectedPatientName) throws SQLException, ClassNotFoundException {
        List<TherapyProgram> therapyPrograms = therapyProgramDAO.getAll();
        List<TherapyProgramDto> therapyProgramDtos = new ArrayList<>();
        for (TherapyProgram therapyProgram : therapyPrograms){
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
}
