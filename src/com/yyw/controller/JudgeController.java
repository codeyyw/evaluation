package com.yyw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yyw.entity.Judge;
import com.yyw.entity.Project;
import com.yyw.service.JudgeService;
import com.yyw.service.ProjectService;
import com.yyw.utils.FindFiles;
import com.yyw.utils.introPro;

@Controller
@RequestMapping("judge")
public class JudgeController {

	@Autowired
	JudgeService judgeService;

	public JudgeService getJudgeService() {
		return judgeService;
	}

	public void setJudgeService(JudgeService judgeService) {
		this.judgeService = judgeService;
	}

	@Autowired
	ProjectService projectService;

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping("toJudge")
	public ModelAndView toJudge() {

		ModelAndView mav = new ModelAndView("judge");

		return mav;

	}

	@RequestMapping("toLogin")

	public ModelAndView toLgoin() {
		ModelAndView mav = new ModelAndView("jLogin");

		return mav;
	}

	@RequestMapping("/loginCommit")
	public ModelAndView loginCommit(String loginName, String loginPassword, HttpSession session) {

		ModelAndView mav = new ModelAndView("redirect:/index.jsp");

		Judge judge = judgeService.login(loginName, loginPassword);

		if (judge != null) {
			session.setAttribute("ROLE", "judge");
			session.setAttribute("judge", judge);

			System.out.println(judge.getJudge_name() + "评委成功登录");
		} else {

			System.out.println("评委登录失败，请检查登录信息是否正确");
		}

		return mav;

	}

	@RequestMapping("showInfo")

	public ModelAndView jShowInfo() {

		ModelAndView mav = new ModelAndView("jShowInfo");

		return mav;

	}
	//分配项目
	@RequestMapping("assignPros")

	public ModelAndView projectJudge(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/judge/canJudge");
		Judge judge = (Judge) session.getAttribute("judge");
		

		//List<Project> projects = projectService.findByType(type);
		List<Project> projects = judgeService.findByJudge(judge);
		if(projects==null) {
			System.out.println("该评委已经评审完说有该专业的项目，666");
			mav.setViewName("redirect:/index.jsp");
		}
		System.out.println("JudgeController====" + projects);
		session.setAttribute("projects", projects);
		return mav;

	
	}

	@RequestMapping("canJudge")
	
	public ModelAndView canJudge(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		Judge judge = (Judge) session.getAttribute("judge");
		@SuppressWarnings("unchecked")
		List<Project> projects = (List<Project>) session.getAttribute("projects");
		
		String type = judge.getJudge_profession();
		if(projects!=null) {
			mav.setViewName("projectJudge");
			

				System.out.println("查询到的" + type + "类项目列表:" + projects);

				// 将项目的附件添加到map中返回给前端
				for (Project project : projects) {

					List<String> fileList = FindFiles.findfileNames(project.getProject_name());
					
					project.setFileNames(fileList);
					
					/*String[] fileNames = (String[]) fileList.toArray(new String[fileList.size()]);
					project.setFileNames(fileNames);*/
					System.out.println("查询到的项目附件====" + fileList);
				}
				session.setAttribute("projects", projects);
		
		}else {
			
			mav.setViewName("redirect:/judge/assignPros");
		}
		
		return mav;
	}
	@RequestMapping("judgeProject")

	public ModelAndView judgeProject(HttpServletResponse response, HttpServletRequest request, HttpSession session) {
		
		System.out.println("提交评分=====JudgeController");
		
		ModelAndView mav = new ModelAndView();

		Judge judge = (Judge) session.getAttribute("judge");
		System.out.println("controller===评委judge"+judge);

		String[] projectLevels = request.getParameterValues("project_level");

		@SuppressWarnings("unchecked")
		List<Project> projects = (List<Project>) session.getAttribute("projects");
		System.out.println(projects);
		boolean recordRes = introPro.grade(judge,projectLevels, projects, judgeService);
		System.out.println("插入成功哈哈啊哈"+recordRes);
		// 更新是否成功,成功的话清空session的project,换一批项目
		if(recordRes) {
			
			//清空现在的项目集合然后返回重新分配项目
			session.removeAttribute("projects");
			mav.setViewName("redirect:/judge/assignPros");
			
		}else {
			//保留项目，重新发送请求处理
			mav.setViewName("redirect:/judge/canJudge");
		}
		return mav;
	}
}
