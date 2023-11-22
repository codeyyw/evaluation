package com.yyw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yyw.entity.Admin;
import com.yyw.entity.Contributor;
import com.yyw.entity.Judge;

import com.yyw.service.AdminService;
import com.yyw.service.JudgeService;
import com.yyw.utils.AdminVerify;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Autowired
	JudgeService judgeService;

	

	public JudgeService getJudgeService() {
		return judgeService;
	}

	public void setJudgeService(JudgeService judgeService) {
		this.judgeService = judgeService;
	}

	@RequestMapping("toAdmin")

	public ModelAndView toAdmin() {
		ModelAndView mav = new ModelAndView("admin");

		return mav;

	}

	@RequestMapping("toLgoin")

	public ModelAndView toLgoin() {
		ModelAndView mav = new ModelAndView("aLogin");

		return mav;

	}

	@RequestMapping("/loginCommit")
	public ModelAndView loginCommit(String loginName, String loginPassword, HttpSession session) {

		ModelAndView mav = new ModelAndView("redirect:/index.jsp");

		if (AdminVerify.verify(loginName, loginPassword)) {
			session.setAttribute("ROLE", "admin");
			session.setAttribute("admin", Admin.getInstance());
			
			System.out.println("管理员成功登录");
		}

		return mav;

	}

	@RequestMapping("toPlayerCondition")
	public ModelAndView playerCondition(HttpSession session) {

		ModelAndView mav = new ModelAndView("playerCondition");

		List<Contributor> players = null;
		players = adminService.findAllPlayer();

		session.setAttribute("players", players);

		return mav;

	}

	@RequestMapping("toJudgeManager")

	public ModelAndView toJudgeManager(HttpSession session) {

		ModelAndView mav = new ModelAndView("judgeManager");

		List<Judge> judges = null;

		judges = judgeService.findAllJudge();

		System.out.println("评委=====" + judges);
		session.setAttribute("judges", judges);
		return mav;

	}
	
	@RequestMapping("addJudge")
	@ResponseBody
	public JSONObject addPerson(HttpServletRequest request,HttpServletResponse response, Judge judge) {

		
		
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		System.out.println("addJudge======="+judge);
		 Map<String,String> map = new HashMap<String,String>();

		if (judgeService.addJudge(judge)) {	
			map.put("result", "评委添加成功") ;
			System.out.println("成功哈哈啊哈");
		}else{
			map.put("result", "评委添加失败") ;
		}
		JSONObject json = JSONObject.fromObject(map);
		return json;

	}
}
