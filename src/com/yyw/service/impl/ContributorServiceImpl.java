package com.yyw.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.yyw.dao.ContributorMapper;
import com.yyw.entity.Contributor;
import com.yyw.entity.Project;
import com.yyw.service.ContributorService;

@Service("cservice")
public class ContributorServiceImpl implements ContributorService {

	@Autowired
	private ContributorMapper contributorMapper;

	public void setContributorMapper(ContributorMapper contributorMapper) {
		this.contributorMapper = contributorMapper;
	}

	public ContributorMapper getContributorMapper() {
		return contributorMapper;
	}

	@Override
	public boolean addContributor(Contributor contributor) {

		boolean result = false;

		int insert = 0;

		insert = contributorMapper.insertContributor(contributor);

		System.out.println("这位投稿人的id为：" + insert);

		result = insert > 0 ? true : false;

		return result;

	}

	@Override
	public Contributor login(String loginName, String loginPassword) {

		HashMap<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("loginName", loginName);
		hashMap.put("loginPassword", loginPassword);

		Contributor contributor = null;

		contributor = contributorMapper.findByName(hashMap);

		if (contributor!=null) {
			System.out.println("这位投稿人存在，允许登录" + contributor);
		}else {
			System.out.println("这位投稿人不存在");
		}
		return contributor;
	}

	
	//根据投稿人id在项目表中查找关联项目
	@Override
	public Project findProjectById(Integer ContributorId) {
		
		Project project = null;
		project = contributorMapper.selectProject(ContributorId);

		if(project!=null) {
			
			System.out.println("查询成功，该投稿人上传的项目为"+project);
		}else {
			System.out.println("该投稿人还未上传项目");
		}
		return project;
	}

	@Override
	public Contributor check(String userName){
		Contributor contributor = contributorMapper.check(userName);
		if(contributor!=null) {
			System.out.println("该投稿人已经存在，不能用这个名字进行注册");
		}else {
			System.out.println("可以注册");
		}
	
		return contributor;
	}

}
