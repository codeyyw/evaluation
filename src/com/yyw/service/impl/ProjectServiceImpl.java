package com.yyw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyw.dao.JudgeMapper;
import com.yyw.dao.PersonMapper;
import com.yyw.dao.ProjectMapper;
import com.yyw.entity.Contributor;
import com.yyw.entity.Person;
import com.yyw.entity.ProAndTeam;
import com.yyw.entity.Project;
import com.yyw.entity.Scores;
import com.yyw.service.ProjectService;
import com.yyw.utils.CountScores;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	private JudgeMapper judgeMapper;
	
	@Autowired
	private PersonMapper personMapper;

	@Override
	public Boolean addProject(HashMap<String, Object> hashMap) {

		boolean result = false;

		int insert = 0;
		int upload = 0;

		Contributor contributor = (Contributor) hashMap.get("contributor");
		contributor.setContributor_isUpload(1);
		hashMap.put("contributor_id", contributor.getContributor_id());

		insert = projectMapper.insertProject(hashMap);
		upload = projectMapper.updateUpload(contributor);

		System.out.println("这位投稿人提交的项目id为：" + insert);

		result = (insert > 0) && (upload > 0) ? true : false;

		return result;

	}

	@Override
	public Project getProject(Integer projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> findAllProjects() {

		List<Project> projects = projectMapper.selectAll();

		if (projects == null) {
			System.out.println("数据库中没有查询到任何项目");
		}
		return projects;
	}

	@Override
	public List<Project> findByType(String type) {
		List<Project> projects = projectMapper.selectByType(type);
		System.out.println(projects);
		if (projects.size() != 0) {
			System.out.println(type + "类的项目个数" + projects.size());
		} else {
			System.out.println("数据库中目前还没有" + type + "类的项目");
		}
		return projects;
	}

	// 对项目的评分表结果进行汇总后给项目给出总分
	@Override
	public boolean setProLevels() {

		List<Project> proList = projectMapper.selectAll();
		Iterator<Project> it = proList.iterator();
		
		boolean res = true;
		// 遍历每一个在数据库project表中存在的项目，然后对每个项目的project_level字段进行更新
		while (it.hasNext()&&res) {
			Project project = it.next();
			// 先得到项目的scores评分表
			Scores scores = judgeMapper.getScores(project);
			if (scores != null) {

				// 去除掉scores表中为null的评分，将剩下的评分以链表的形式返回
				float ave = CountScores.count(scores);
				//System.out.println("该项目的project_level为："+ave);
				
				project.setProject_level(ave);
				//更新项目信息（project_level）
				int updateRes = projectMapper.updateProLevel(project);
				res = updateRes>0?true:false;	
			}
		}
		return res;

	}

	@Override
	public List<ProAndTeam> findProAndTeam(String type) {
		List<ProAndTeam> ptList = new ArrayList<ProAndTeam>();
		
		//排序后的项目集合
		List<Project> pros = projectMapper.selectByTypeOrder(type);
		
		//封装ptList集合
		if(pros!=null) {
			for(Project pro:pros) {
				//每个项目对应一个ProAndTeam
				ProAndTeam pt = new ProAndTeam();
				pt.setProject(pro);
				
				List<Person> team = personMapper.selectAll(pro.getProject_team());
				
				pt.setTeam(team);
				
				ptList.add(pt);		
			}
		}
		return ptList;
	}

	@Override
	public List<Project> findProByOrder(String type) {
		// TODO Auto-generated method stub
		return projectMapper.selectByTypeOrder(type);
	}
}
