package com.yyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyw.dao.ContributorMapper;
import com.yyw.entity.Contributor;
import com.yyw.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	ContributorMapper contributorMapper;
	
	
	public ContributorMapper getContributorMapper() {
		return contributorMapper;
	}


	public void setContributorMapper(ContributorMapper contributorMapper) {
		this.contributorMapper = contributorMapper;
	}


	@Override
	public List<Contributor> findAllPlayer() {
		List<Contributor> players = contributorMapper.selectAll();
		if(players==null) {
			
			System.out.println("====目前还没有选手报名====");
		}
		System.out.println(players);
		return players;
	}

}
