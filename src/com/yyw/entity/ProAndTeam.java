package com.yyw.entity;

import java.util.List;

public class ProAndTeam {

	
	private Project project;
	private List<Person> team;
	public ProAndTeam() {
		super();
	}
	public ProAndTeam(Project project, List<Person> team) {
		super();
		this.project = project;
		this.team = team;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<Person> getTeam() {
		return team;
	}
	public void setTeam(List<Person> team) {
		this.team = team;
	}
	@Override
	public String toString() {
		return "ProAndTeam [project=" + project + ", team=" + team + "]";
	}
	
	
}
