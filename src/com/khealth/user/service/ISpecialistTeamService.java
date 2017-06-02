package com.khealth.user.service;

import java.util.List;

import com.khealth.user.pojo.SpecialistTeam;

public interface ISpecialistTeamService {
	
	public int addSpecialistTeam(SpecialistTeam specialistTeam);
	
	public int removeSpecialistTeamByID(int id);
   
	public int modifySpecialistTeam(SpecialistTeam specialistTeam);	
	
	public SpecialistTeam getSpecialistTeamById(int id);
			
	public List<SpecialistTeam> getAllSpecialistTeamList();
    
	public List<SpecialistTeam> getSpecialistTeamByParaByPage(SpecialistTeam specialistTeam);
    
	public List<SpecialistTeam> getSpecialistTeamByPage(SpecialistTeam specialistTeam);
    
	public List<SpecialistTeam> getSpecialistTeamRankByPage(SpecialistTeam specialistTeam);
}
