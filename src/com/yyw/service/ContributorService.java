package com.yyw.service;

import com.yyw.entity.Contributor;
import com.yyw.entity.Project;

public interface ContributorService {
	
	//投稿人注册信息
	public boolean addContributor(Contributor contributor);
	
	//投稿人登录
	public Contributor login(String loginName,String loginPassword);
	
	//根据投稿人id查找投稿人
	public Project findProjectById(Integer ContributorId);
	//注册判断
	public Contributor check(String userName);
}
