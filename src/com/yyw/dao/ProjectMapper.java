package com.yyw.dao;

import java.util.HashMap;
import java.util.List;

import com.yyw.entity.Contributor;
import com.yyw.entity.Project;


public interface ProjectMapper {
	//插入项目到数据库表中
	public Integer insertProject(HashMap<String, Object> hashMap);

	//查询所有项目
	public List<Project> selectAll();
	//通过项目类型查找项目
	public List<Project> selectByType(String type);
	
	//当投稿人提交项目后更新投稿人表字段
	public Integer updateUpload(Contributor contributor);
	//通过项目id查找项目
	public Project selectById(Integer projectId);

	//更新项目信息project_level
	public int updateProLevel(Project project);

	//降序查找对应项目集合
	public List<Project> selectByTypeOrder(String type);


}
