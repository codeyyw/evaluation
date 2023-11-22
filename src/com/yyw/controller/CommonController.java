package com.yyw.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyw.entity.Contributor;
import com.yyw.entity.Person;
import com.yyw.entity.ProAndTeam;
import com.yyw.entity.Project;
import com.yyw.service.ContributorService;
import com.yyw.service.JudgeService;
import com.yyw.service.ProjectService;

@Controller
public class CommonController {

	@Autowired
	ContributorService contributorService;

	@Autowired
	JudgeService judgeService;

	@Autowired
	ProjectService projectService;

	public ContributorService getContributorService() {
		return contributorService;
	}

	public void setContributorService(ContributorService contributorService) {
		this.contributorService = contributorService;
	}

	public JudgeService getJudgeService() {
		return judgeService;
	}

	public void setJudgeService(JudgeService judgeService) {
		this.judgeService = judgeService;
	}

	@RequestMapping("/outLogin")

	public ModelAndView outLogin(HttpSession session) {

		ModelAndView mav = new ModelAndView("redirect:/index.jsp");

		session.removeAttribute("contributor");
		session.removeAttribute("project");
		session.removeAttribute("judge");
		session.removeAttribute("admin");
		session.removeAttribute("ROLE");
		return mav;
	}

	// 普通用户拿排序后的项目和团队数据
	@RequestMapping("setProLevels")
	@ResponseBody
	public void setProLevels(HttpSession session, HttpServletRequest request) {

		boolean res = projectService.setProLevels();
		System.out.println("==============刷新表评分成功" + res);
	}

	@RequestMapping("getProject")
	public ModelAndView getProject(HttpSession session, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("userPros");
		String type = request.getParameter("type");

		List<ProAndTeam> ptList = null;

		ptList = projectService.findProAndTeam(type);

		session.setAttribute("type", type);
		session.setAttribute("pts", ptList);
		return mav;
	}
	
	//分页查询
	// 跳转到推荐项目或者推荐团队界面
	@RequestMapping("getProAndTeam")
	public ModelAndView getTeam(@RequestParam(value="pn",defaultValue="1")Integer pn,HttpSession session, String type, String toUrl) {

		ModelAndView mav = new ModelAndView();
		System.out.println("type" + type + "======toUrl====" + toUrl);
		mav.setViewName(toUrl);
		session.setAttribute("type", type);
		
		
		//List<ProAndTeam> ptList = projectService.findProAndTeam(type);
		

		if (toUrl.equals("userPros")) {

			PageHelper.startPage(pn,10);
				//分页插件的，pn当前页数，一页显示2条记录
			List<Project> pros = projectService.findProByOrder(type);
				PageInfo<Project> page = new PageInfo<Project>(pros, 5);
				System.out.println(pros);
				session.setAttribute("pagePros", page);
				session.setAttribute("pros", pros);
			}

		if (toUrl.equals("userTeams")) {
			List<ProAndTeam> ptList = projectService.findProAndTeam(type);
			//Map<List<Person>, Integer> teams = new LinkedHashMap<List<Person>, Integer>();
			List<List<Person>> teams = new ArrayList<List<Person>>();
			if (ptList != null) {
				for (ProAndTeam pt : ptList) {
					List<Person> persons = pt.getTeam();
					teams.add(persons);
				}
				System.out.println(teams);
				//5为一次显示的页数
				session.setAttribute("teams", teams);
			}

		}
		return mav;
	}

	@RequestMapping("/cRegisterCheck")
	@ResponseBody
	public void cRegisterCheck(HttpServletRequest request,PrintWriter pw) {

			String contributor_name = request.getParameter("contributor_name");
	        System.out.println("你输入的是="+contributor_name);
	       
	        Contributor contributor = contributorService.check(contributor_name);
	      
	        if(contributor!=null){
	        	pw.println("用户名已经被注册！");
	        }
	}

}
