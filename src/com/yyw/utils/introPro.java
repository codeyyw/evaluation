package com.yyw.utils;

import java.util.Collections;

import java.util.Iterator;
import java.util.List;

import com.yyw.dao.JudgeMapper;
import com.yyw.dao.ProjectMapper;
import com.yyw.entity.Judge;
import com.yyw.entity.Project;
import com.yyw.service.JudgeService;

public class introPro {

	public static List<Project> introProject(Judge judge, JudgeMapper judgeMapper, ProjectMapper projectMapper) {

		System.out.println(judge);

		// 拿到该专业所有的项目
		List<Project> allProjects = projectMapper.selectByType(judge.getJudge_profession());
		//最后的项目
		List<Project> subProjects;

		System.out.println("打乱前该专业项目：" + allProjects);

		// 使集合乱序，一定要先打乱后去除在截取（截取时进行判断）
		Collections.shuffle(allProjects);
		System.out.println("打乱后该专业项目=====" + allProjects);
		// 通过查看jp表来查看评委评审过的项目，
		Judge findJudge = judgeMapper.findProjects(judge);
		
		// 如果项目为空不做去重处理操作
		// 如果评审以前评审过项目，去重
		if (findJudge != null) {
			// 该评委评审过项目，添加项目=====（判空）
			judge = findJudge;
			System.out.println(judge);
			List<Project> JudgeProjects = judge.getProjects();	
			System.out.println("评委评审过的项目：" + JudgeProjects);
			// 遍历评委打过分的项目
			for (Project jProject : JudgeProjects) {
				// 迭代器遍历所有该类型项目
				Iterator<Project> it = allProjects.iterator();
				System.out.println("遍历到的项目：" + jProject);

				while (it.hasNext()) {
					Project project = it.next();
					// System.out.println("遍历到的all项目：======"+project);
					// 判断项目是否相同
					if (project.equals(jProject)) {
						System.out.println("该项目已经被这位评委审核过,去除");
						it.remove();
					}
				}
			}
		}
		else {
			subProjects = allProjects;
		}
		// 测试判断是否去重成功
		System.out.println("检查后剩余项目=====" + allProjects.size());
		// 从第0个元素（因为List的序号从0开始）开始，到第5个元素结束，但是不包括第5个元素。
		subProjects = allProjects;
		if (allProjects.size() > 5) {
			subProjects = allProjects.subList(0, 5);
			System.out.println("打乱后5条项目=====" + subProjects);
		}else {
			System.out.println("项目不足5条===" + subProjects.size());
		}
	
			// subProject是返回给前台评委的项目
			return subProjects;
}
		
	// 将项目和项目的对应评分对应插入
	public static boolean grade(Judge judge, String[] projectLevels, List<Project> projects,
			JudgeService judgeService) {

		System.out.println("controller====评审");
		// 迭代器
		Iterator<Project> it = projects.iterator();
		int i = 0;
		System.out.println(projectLevels);
		for (String ss : projectLevels) {
			System.out.println(ss);
		}
		//判断评委是否评分的标准
		boolean updateRes = false;
		boolean recordRes = true;

		while (it.hasNext() &&recordRes) {
			Project project = it.next();
			System.out.println(project);
			// 对项目的评分数据表中插入数据(权重)
			if(!projectLevels[i].equals("0")){
				//评委选择评分，更新评分表
			updateRes = judgeService.setProScores(project, judge.getJudge_star()*Float.parseFloat(projectLevels[i]));
			System.out.println("评分不为0"+projectLevels[i]);
			}else {
				//评委没有评分，jp表不更新
				updateRes=false;
				System.out.println("评分为0");
			}
			// 如果该记录数据插入成功，更新关联表
			if (updateRes) {
				recordRes = judgeService.setJP(project, judge);
			}
			i++;
		}
		return recordRes;
	}

}
