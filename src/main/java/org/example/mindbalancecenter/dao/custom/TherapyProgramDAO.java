package org.example.mindbalancecenter.dao.custom;

import org.example.mindbalancecenter.dao.CrudDAO;
import org.example.mindbalancecenter.entitiy.TherapyProgram;

public interface TherapyProgramDAO extends CrudDAO<TherapyProgram> {
    TherapyProgram searchByName(String name);
}
