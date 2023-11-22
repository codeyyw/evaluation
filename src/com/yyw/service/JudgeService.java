package com.yyw.service;

import java.util.List;

import com.yyw.entity.Judge;
import com.yyw.entity.Project;


public interface JudgeService {
	
	//查找所欲评委
	public List<Judge> findAllJudge();

	//评委登录验证
	public Judge login(String loginName, String loginPassword);
	
	public boolean setProjectLevel(Project project);

	public boolean addJudge(Judge judge);
	//通过评委随机分配给评委项目
	public List<Project> findByJudge(Judge judge);

	//设置项目对应的评分表
	public boolean setProScores(Project project, float parseFloat);

	//更新关联表
	public boolean setJP(Project project, Judge judge);
}
