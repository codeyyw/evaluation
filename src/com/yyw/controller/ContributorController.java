package com.yyw.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yyw.entity.Contributor;
import com.yyw.entity.Project;
import com.yyw.service.ContributorService;
import com.yyw.utils.FindFiles;

@Controller
@RequestMapping("contributor")
public class ContributorController {
	@Autowired
	@Qualifier("cservice")
	private ContributorService contributorService;

	public void setContributorService(ContributorService contributorService) {
		this.contributorService = contributorService;
	}

	public ContributorService getContributorService() {
		return contributorService;
	}

	// 投稿者报名渠道
	@RequestMapping("/toRegister")
	
	public ModelAndView toRegister(HttpSession session) {
		
		session.removeAttribute("contributor");
		 ModelAndView mav = new ModelAndView("cRegister");
		
		return mav;
		
	}

		//投稿者登录渠道
	@RequestMapping("/toLogin")

	public ModelAndView toLogin() {
		ModelAndView mav = new ModelAndView("cLogin");

		return mav;

	}
	
	//投稿人个人信息展示
	@RequestMapping("showInfo")
	
	public ModelAndView cShowInfo(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("cShowInfo");
		Contributor contributor = (Contributor) session.getAttribute("contributor");
		Project project = null;
		
		project = contributorService.findProjectById(contributor.getContributor_id());
		
		if(project!=null) {
			System.out.println("即将跳转到项目展示界面");
			//将项目信息存放在session中
			session.setAttribute("project", project);
			List<String> fileNames = FindFiles.findfileNames(project.getProject_name());
			if(fileNames!=null) {
				System.out.println("查询到的项目附件===="+fileNames);
				session.setAttribute("fileNames", fileNames);
			}
			
		}else {
			System.out.println("还未上传项目，请先上传项目");
		}
		
		
		
		return mav;
		
		
	}
	
	// 投稿者信息提交注册信息
	@RequestMapping("/registerCommit")

	public ModelAndView registerCommit(Contributor contributor) {

		// 创建一个模型视图对象
		ModelAndView mav = new ModelAndView();

		System.out.println(contributor);
		
		if(contributorService.check(contributor.getContributor_name())==null) {
			System.out.println("可以注册");
			if (contributorService.addContributor(contributor)) {
				//login页面 / 控制器方法？
				mav.setViewName("forward:toLogin");

			} else {
				mav.setViewName("redirect:/index.jsp");
			}
			
		}else {
			mav.setViewName("forward:toRegister");
			System.out.println("投稿人用户名重复，不能注册");
		}

	
		// 返回ModelAndView对象mav
		return mav;

	}

	@RequestMapping("/loginCommit")
	public ModelAndView loginCommit(@RequestParam("loginName") String loginName,
			@RequestParam("loginPassword") String loginPassword,HttpSession session) {

		ModelAndView mav = new ModelAndView("redirect:/index.jsp");

		Contributor contributor = null;
		contributor = contributorService.login(loginName, loginPassword);

		if (contributor != null) {

	
			
			session.setAttribute("ROLE", "contributor");
			session.setAttribute("contributor", contributor);
			
			System.out.println(contributor.getContributor_name() + "投稿人成功登录");

		} else {
			System.out.println("登录失败");
		}

		return mav;

	}
}
