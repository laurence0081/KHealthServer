package com.khealth.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.khealth.user.dao.ISpecialistTeamDao;
import com.khealth.user.pojo.SpecialistTeam;
import com.khealth.user.service.ISpecialistTeamService;

@Service("specialistTeamService")
public class SpecialistTeamServiceImpl implements ISpecialistTeamService {
	@Resource
	private ISpecialistTeamDao specialistTeamDao;
	
	private int result = 0;
	
	public int addSpecialistTeam(SpecialistTeam specialistTeam){
		result = this.specialistTeamDao.insert(specialistTeam);
		return result;
	}

	public int removeSpecialistTeamByID(int id){
		return this.specialistTeamDao.deleteById(id);
	}
   
	public int modifySpecialistTeam(SpecialistTeam specialistTeam){
		result = this.specialistTeamDao.update(specialistTeam);
		return result;
	}
	
	public SpecialistTeam getSpecialistTeamById(int id){
		return this.specialistTeamDao.selectById(id);
	}

	public ISpecialistTeamDao getSpecialistTeamDao() {
		return specialistTeamDao;
	}

	public void setSpecialistTeamDao(ISpecialistTeamDao specialistTeamDao) {
		this.specialistTeamDao = specialistTeamDao;
	}	
	
	public List<SpecialistTeam> getAllSpecialistTeamList(){
		return this.specialistTeamDao.selectAllSpecialistTeamList();
	}
    
	public List<SpecialistTeam> getSpecialistTeamByParaByPage(SpecialistTeam specialistTeam){
		return specialistTeamDao.selectByParaByPage(specialistTeam);
	}
    
	public List<SpecialistTeam> getSpecialistTeamByPage(SpecialistTeam specialistTeam){
		return specialistTeamDao.selectByPage(specialistTeam);
	}
    
	public List<SpecialistTeam> getSpecialistTeamRankByPage(SpecialistTeam specialistTeam){
		return specialistTeamDao.selectRankByPage(specialistTeam);
	}
}
