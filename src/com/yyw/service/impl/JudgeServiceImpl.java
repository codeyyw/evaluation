package com.yyw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyw.dao.JudgeMapper;
import com.yyw.dao.ProjectMapper;
import com.yyw.entity.Judge;
import com.yyw.entity.Project;
import com.yyw.entity.Scores;
import com.yyw.service.JudgeService;
import com.yyw.utils.introPro;

@Service
public class JudgeServiceImpl implements JudgeService {

	@Autowired
	JudgeMapper judgeMapper;

	@Autowired
	ProjectMapper projectMapper;

	public JudgeMapper getJudgeMapper() {
		return judgeMapper;
	}

	public void setJudgeMapper(JudgeMapper judgeMapper) {
		this.judgeMapper = judgeMapper;
	}

	@Override
	public List<Judge> findAllJudge() {

		List<Judge> judges = judgeMapper.selectAll();
		if (judges == null) {
			System.out.println("还未添加评委，请管理员尽快联系====");
		}

		return judges;
	}

	@Override
	public Judge login(String loginName, String loginPassword) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("loginName", loginName);
		map.put("loginPassword", loginPassword);

		Judge judge = judgeMapper.findByName(map);
		if (judge == null) {

			System.out.println("数据库中评委信息匹配错误，没有查询到该评委");
		}
		return judge;
	}

	@Override
	public boolean setProjectLevel(Project project) {
		boolean res = false;
		Integer update = judgeMapper.updateLevel(project);
		if (update > 0) {
			res = true;
		}
		return res;
	}

	@Override
	public boolean addJudge(Judge judge) {
		Boolean result = false;

		result = judgeMapper.insertJudge(judge) > 0 ? true : false;
		return result;
	}

	@Override
	public List<Project> findByJudge(Judge judge) {
		List<Project> introProject = introPro.introProject(judge, judgeMapper, projectMapper);
		return introProject;
	}

	// 设置项目对应的评分表记录
	@Override
	public boolean setProScores(Project project, float parseFloat) {
		boolean res = false;
		// 先得到项目的评分表，对评分数量进行判断
		Scores scores = (Scores) judgeMapper.getScores(project);

		System.out.println("scores" + scores);
		if (scores == null) {
			System.out.println("项目" + project.getProject_name() + "评分表为空");
			// 该项目还没有评分过，new一个新的评分链表插入第一条数据
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("projectId", project.getProject_id());
			map.put("score1", parseFloat);
			Integer insertRes = judgeMapper.insertScore(map);

			if (insertRes > 0) {
				System.out.println("项目" + project.getProject_name() + "第一条数据插入成功");
				res = true;
				return res;
			}
		} else {
			System.out.println("项目" + project.getProject_name() + "评分表表不为空");
			// 评委评分过，拿到对项目的评分记录做出更新
			List<Float> sList = scores.getS();
			System.out.println("评分表记录长度"+sList.size());
			if (sList.size() == 10) {
				sList.remove(9);
			}
			sList.add(0,parseFloat);
			// 更新评分记录
			scores.setScore1(sList.get(0));
			scores.setScore2(sList.get(1));
			scores.setScore3(sList.get(2));
			scores.setScore4(sList.get(3));
			scores.setScore5(sList.get(4));
			scores.setScore6(sList.get(5));
			scores.setScore7(sList.get(6));
			scores.setScore8(sList.get(7));
			scores.setScore9(sList.get(8));
			scores.setScore10(sList.get(9));

			Integer updateRes = judgeMapper.updateScores(scores);

			if (updateRes > 0) {
				System.out.println("项目" + project.getProject_name() + "评分表更新成功");
				res = true;
			}
		}
		return res;
	}

	@Override
	public boolean setJP(Project project, Judge judge) {

		System.out.println("setJP====评审");
		boolean updateRes = false;
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("pId", project.getProject_id());
		map.put("jId", judge.getJudge_id());

		updateRes = judgeMapper.insertJP(map) > 0 ? true : false;
		return updateRes;
	}

}
