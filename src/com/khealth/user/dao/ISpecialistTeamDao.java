package com.khealth.user.dao;

import java.util.List;

import com.khealth.user.pojo.SpecialistTeam;

public interface ISpecialistTeamDao {

    int insert(SpecialistTeam specialistTeam);
	
	int deleteById(Integer id);
    
    int update(SpecialistTeam specialistTeam);

    SpecialistTeam selectById(Integer id);
    
    List<SpecialistTeam> selectAllSpecialistTeamList();
    
    List<SpecialistTeam> selectByParaByPage(SpecialistTeam specialistTeam);
    
    List<SpecialistTeam> selectByPage(SpecialistTeam specialistTeam);
    
    List<SpecialistTeam> selectRankByPage(SpecialistTeam specialistTeam);
}
