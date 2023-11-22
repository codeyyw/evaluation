package com.yyw.test;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyw.dao.ContributorMapper;
import com.yyw.dao.JudgeMapper;
import com.yyw.dao.ProjectMapper;
import com.yyw.entity.Contributor;
import com.yyw.entity.Judge;
import com.yyw.entity.Project;
import com.yyw.entity.Scores;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class SSMTest {
	@Autowired
	private ContributorMapper contributorMapper;

	@Autowired
	private ProjectMapper projectMapper;

	@Autowired
	private JudgeMapper judgeMapper;

	@Test
	public void runBy() {
		List<Contributor> all = contributorMapper.selectAll();

		System.out.println(all);
		for (Contributor contributor : all) {

			System.out.println(contributor);
		}
	}

	@Test
	public void testDemo() {
		List<Float> lList = new LinkedList<Float>();
		lList.add((float) 1.2);
		lList.add((float) 2.2);
		lList.add((float) 1.5);
		lList.add((float) 3.2);
		lList.add((float) 4.2);
		System.out.println(lList);
		// lList.remove(0);
		lList.remove(0);
		lList.add((float) 8.8);
		System.out.println(lList);

	}

	@Test
	public void judge() {

		List<Project> projects = projectMapper.selectByType("物联网");
		System.out.println(projects);
		for (Project project : projects) {

			System.out.println(project);
		}
	}

	@Test
	public void introProject() {

		Map<String, String> map = new HashMap<>();
		map.put("loginName", "yuan");
		map.put("loginPassword", "yuan");
		Judge judge = judgeMapper.findByName(map);
		System.out.println(judge);

		// 通过查看jJudgeP表来查看评委评审过的项目，

		judge = judgeMapper.findProjects(judge);
		System.out.println(judge);
		List<Project> JudgeProjects = judge.getProjects();

		// 拿到该专业所有的项目
		List<Project> allProjects = projectMapper.selectByType(judge.getJudge_profession());

		System.out.println("打乱前该专业项目：" + allProjects);

		// 使集合乱序，一定要先打乱后去除在截取（截取时进行判断）
		Collections.shuffle(allProjects);
		System.out.println("打乱后该专业项目=====" + allProjects);

		// 如果项目为空不做去重处理操作
		// 如果评审以前评审过项目，去重
		if (JudgeProjects != null) {
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
		// 测试判断是否去重成功
		System.out.println("检查后剩余项目=====" + allProjects.size());

		// 从第0个元素（因为List的序号从0开始）开始，到第10个元素结束，但是不包括第10个元素。

		List<Project> subProjects = allProjects;
		if (allProjects.size() > 10) {
			subProjects = allProjects.subList(0, 10);
			System.out.println("打乱后前十条项目=====" + subProjects.size());
		} else {

			subProjects = allProjects;
			System.out.println("项目不足十条===" + subProjects.size());
		}

		// subProject是返回给前台评委的项目

	}

	// 去掉null元素
	@Test
	public void setProLevel() {
		Project p = new Project();
		p.setProject_id(70);
		Scores scores = judgeMapper.getScores(p);
		System.out.println(scores);
		List<Float> s = scores.getS();
		System.out.println(s + "======" + s.size());

		Iterator<Float> it = s.iterator();
		while (it.hasNext()) {

			Float f = it.next();
			if (f == null) {
				it.remove();

			}
		}
		System.out.println(s + "排序前======" + s.size());
		float sum = 0;
		float ave = 0;
		if (s.size() >= 7) {
			// 降序排序，默认为升序
			Comparator<Float> reverseComparator = Collections.reverseOrder();
			Collections.sort(s, reverseComparator);
			//去掉一个最大值和一个最小值，剩余的scores求平均数
			s.remove(0);
			s.remove(s.size() - 1);
			System.out.println(s + "排序后======" + s.size());
			for (float a : s) {
				sum = sum + a;
			}
			sum++;
			System.out.println("和：" + sum);
			//求商
			float a = sum / s.size();
			//求余
			float b = sum % s.size();
			
			ave = a+b;
			
			System.out.println(ave);
		}

	}
}
