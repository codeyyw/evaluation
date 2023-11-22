package com.yyw.dao;

import java.util.List;
import java.util.Map;

import com.yyw.entity.Judge;
import com.yyw.entity.Project;
import com.yyw.entity.Scores;

public interface JudgeMapper {
	
	//查找评委
	public List<Judge> selectAll();

	//评委登录
	public Judge findByName(Map<String, String> map);
	
	//项目评分
	public Integer updateLevel(Project project);
	//添加评委
	public int insertJudge(Judge judge);

	//通过评委id去关联表中查找该评委评审过的项目
	public Judge findProjects(Judge judge);

	//获取项目对应的评分数据集记录
	public Scores getScores(Project project);

	//插入第一条数据
	public Integer insertScore(Map<String, Object> map);
	
	//更新数据库中评分表
	public Integer updateScores(Scores scores);
	
	//插入评分关系到jp关联表中
	public Integer insertJP(Map<String, Integer> map);


}
