package org.example.mindbalancecenter.bo.impl;

import org.example.mindbalancecenter.bo.TherapistBO;
import org.example.mindbalancecenter.dao.DAOFactory;
import org.example.mindbalancecenter.dao.custom.TherapistDAO;
import org.example.mindbalancecenter.dto.tm.TherapistTM;
import org.example.mindbalancecenter.entitiy.Therapist;

public class TherapistBOImpl implements TherapistBO {
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPIST);
    @Override
    public void save(TherapistTM therapistTM) {
//        therapistDAO.save(new Therapist(
//                therapistTM.getId(),
//                therapistTM.getName(),
//                therapistTM.getPhoneNumber(),
//                therapistTM.getExperienceYear(),
//                therapistTM.getSpecialization()
//        ));
    }
}
