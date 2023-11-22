package com.yyw.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.yyw.entity.Contributor;
import com.yyw.entity.Project;
import com.yyw.service.ProjectService;
import com.yyw.utils.UploadFiles;

@Controller
@RequestMapping("project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	
	//跳到报名选手主界面
	@RequestMapping("/toContributor")
	
	public ModelAndView toContributor() {
		
		ModelAndView mav =  new ModelAndView("contributor");
		
		return mav;
	
	}
	
	// 跳到项目表单界面
	@RequestMapping("toReferPro")
	public ModelAndView toReferPro(HttpSession session) {

		ModelAndView mav = new ModelAndView("referPro");
		System.out.println("toReferPro");
		Contributor contributor = (Contributor)session.getAttribute("contributor");
		
		Integer isUpload = contributor.getContributor_isUpload();
		System.out.println(contributor+"===="+isUpload);
		
		if(contributor.getContributor_isUpload()==1) {
			System.out.println("该投稿人已经上传项目"+contributor.getProject());
			mav.setViewName("redirect:/index.jsp");		
		}else {
			System.out.println("该投稿人还未上传项目，即将跳到项目上传界面");
			mav.setViewName("referPro");
		}
		

		

		return mav;

	}

	// 提交项目,附件存在磁盘中，项目其他信息存在表project中
	@RequestMapping("referPro")
	public ModelAndView referPro(Project project, HttpSession session, MultipartFile file1, MultipartFile file2,
			MultipartFile file3) {

		ModelAndView mav = new ModelAndView();

		System.out.println("referPro");

		// 谁提交项目，通过session获取该投稿人的信息，然后和项目绑定
		Contributor contributor = (Contributor) session.getAttribute("contributor");

		System.out.println(contributor);
		System.out.println(project);

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		project.setProject_level(0);
		hashMap.put("project", project);
		hashMap.put("contributor", contributor);

		String projectName = project.getProject_name();

		String savePath = "D:\\evauation\\uploads\\" + projectName;
		File dir = new File(savePath);
		dir.mkdirs();
		MultipartFile[] files = { file1, file2, file3 };
		Boolean result = UploadFiles.saveFiles(files, savePath);

		System.out.println(hashMap);
		if (projectService.addProject(hashMap) && result) {
			System.out.println("项目提交成功---");
			mav.setViewName("redirect:/index.jsp");
		} else {
			System.out.println("项目提交失败，请重新提交");
			mav.setViewName("forward:toReferPro");
		}
		return mav;
	}
}
