package com.yyw.dao;

import java.util.HashMap;
import java.util.List;

import com.yyw.entity.Contributor;
import com.yyw.entity.Project;

public interface ContributorMapper {
	
	//增加新的投稿人
	public Integer insertContributor(Contributor cntributor);

	 //通过投稿人姓名查找
	public Contributor findByName(HashMap<String, String> hashMap);
	
	//根据投稿人id查找项目
	public Project selectProject(Integer contributorId);
	
	//查找所有的投稿人
	public List<Contributor> selectAll();
	//注册判断
	public Contributor check(String userName);

}
