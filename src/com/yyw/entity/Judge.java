package com.yyw.entity;

import java.util.List;

public class Judge {
	
	private Integer judge_id;
	private String judge_name;
	private String judge_password;
	private String judge_profession;
	private Integer judge_star;
	//记录评委评定过的项目
	private List<Project> projects;
	public Judge() {
		super();
	}
	
	public Judge(Integer judge_id, String judge_name, String judge_password, String judge_profession,
			Integer judge_star) {
		super();
		this.judge_id = judge_id;
		this.judge_name = judge_name;
		this.judge_password = judge_password;
		this.judge_profession = judge_profession;
		this.judge_star = judge_star;
	}

	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Integer getJudge_id() {
		return judge_id;
	}

	public void setJudge_id(Integer judge_id) {
		this.judge_id = judge_id;
	}

	public String getJudge_name() {
		return judge_name;
	}
	public void setJudge_name(String judge_name) {
		this.judge_name = judge_name;
	}
	public String getJudge_password() {
		return judge_password;
	}
	public void setJudge_password(String judge_password) {
		this.judge_password = judge_password;
	}
	public String getJudge_profession() {
		return judge_profession;
	}
	public void setJudge_profession(String judge_profession) {
		this.judge_profession = judge_profession;
	}
	public Integer getJudge_star() {
		return judge_star;
	}
	public void setJudge_star(Integer judge_star) {
		this.judge_star = judge_star;
	}

	@Override
	public String toString() {
		return "Judge [judge_id=" + judge_id + ", judge_name=" + judge_name + ", judge_password=" + judge_password
				+ ", judge_profession=" + judge_profession + ", judge_star=" + judge_star + ", projects=" + projects
				+ "]";
	}



}
