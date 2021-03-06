package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Skill;

public interface SkillService {

	public Skill getSkillById(int id);
	
	public List<Skill> getAllSkills();
	
	public boolean deleteSkill(int id);
	
	public boolean updateSkill(Skill skill);
	
	public boolean createSkill(Skill skill);
}
