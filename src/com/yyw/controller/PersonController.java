package com.yyw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yyw.entity.Contributor;
import com.yyw.entity.Person;
import com.yyw.service.PersonService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("person")
public class PersonController {

	@Autowired
	private PersonService personService;

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	/*
	 * @responseBody注解的作用是将controller的方法返回的对象通过适当的转换器转换为指定的格式之后，写入到response对象的body区，
	 * 通常用来返回JSON数据或者是XML
	 * 
	 * 数据，需要注意的呢，在使用此注解之后不会再走视图处理器，而是直接将数据写入到输入流中，他的效果等同于通过response对象输出指定格式的数据。
	 */
	@RequestMapping("addPerson")
	@ResponseBody
	public JSONObject addPerson(HttpServletResponse response, Person person) {

		response.setHeader("Content-type", "text/html;charset=UTF-8");
		System.out.println(person);
		 Map<String,String> map = new HashMap<String,String>();

		if (personService.addPerson(person)) {
			map.put("result", "成员添加成功") ;
			System.out.println("成员"+person);
		}else{
			map.put("result", "成员添加失败") ;
		}
		JSONObject json = JSONObject.fromObject(map);
		return json;
		
	}
	
	
	@RequestMapping("teamInfo")
	public ModelAndView teamInfo(HttpSession session) {
		ModelAndView mav =new  ModelAndView("teamInfo");
		
		List<Person> teamList = null;
		
		Contributor contributor = (Contributor)session.getAttribute("contributor");
		System.out.println("11111111111"+contributor);
		String teamName = contributor.getTeam_name();
				
		teamList = personService.findTeamList(teamName);
		session.setAttribute("teamList", teamList);
		
		return mav;
	}
}
