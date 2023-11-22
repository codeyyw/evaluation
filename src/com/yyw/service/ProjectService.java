package com.yyw.service;

import java.util.HashMap;
import java.util.List;

import com.yyw.entity.ProAndTeam;
import com.yyw.entity.Project;

public interface ProjectService {
	
	//注册项目
	public Boolean addProject(HashMap<String,Object> hashMap);
	
	//查找项目(根据项目id)
	public Project getProject(Integer projectId);

	//查找所有项目
	public List<Project> findAllProjects();

	//根据项目类别查找项目
	public List<Project> findByType(String type);

	//设置项目的评分总结果
	public boolean setProLevels();
	
	//查找项目和对应团队排序后的集合
	public List<ProAndTeam> findProAndTeam(String type);

	//查找排序后的项目
	public List<Project> findProByOrder(String type);

	
}
