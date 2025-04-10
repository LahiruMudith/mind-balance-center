package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.TherapistBO;
import org.example.mindbalancecenter.bo.TherapyProgramBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.dao.custom.TherapyProgramDAO;
import org.example.mindbalancecenter.dto.tm.TherapistTM;

public class TherapyProgramBOImpl implements TherapyProgramBO {
    TherapyProgramDAO therapyProgramDAO = (TherapyProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPY_PROGRAM);
}
