package com.yyw.entity;
/**
 * 投稿人实体类
 * @author Yuan Yuan Yuan
 *Contributor
 */
public class Contributor {
	private Integer contributor_id;
	private String contributor_name;
	private String contributor_password;
	private String contributor_phone;
	private String contributor_mail;
	private String project_name;
	private String team_name;
	private Integer contributor_isUpload;
	private Project project;     	//维护关系
	
	
	public Contributor() {
		super();
	}


	public Contributor(Integer contributor_id, String contributor_name, String contributor_password,
			String contributor_phone, String contributor_mail, String project_name, String team_name) {
		super();
		this.contributor_id = contributor_id;
		this.contributor_name = contributor_name;
		this.contributor_password = contributor_password;
		this.contributor_phone = contributor_phone;
		this.contributor_mail = contributor_mail;
		this.project_name = project_name;
		this.team_name = team_name;
	}


	public Integer getContributor_id() {
		return contributor_id;
	}


	public void setContributor_id(Integer contributor_id) {
		this.contributor_id = contributor_id;
	}


	public String getContributor_name() {
		return contributor_name;
	}


	public void setContributor_name(String contributor_name) {
		this.contributor_name = contributor_name;
	}


	public String getContributor_password() {
		return contributor_password;
	}


	public void setContributor_password(String contributor_password) {
		this.contributor_password = contributor_password;
	}


	public String getContributor_phone() {
		return contributor_phone;
	}


	public void setContributor_phone(String contributor_phone) {
		this.contributor_phone = contributor_phone;
	}


	public String getContributor_mail() {
		return contributor_mail;
	}


	public void setContributor_mail(String contributor_mail) {
		this.contributor_mail = contributor_mail;
	}


	public String getProject_name() {
		return project_name;
	}


	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}


	public String getTeam_name() {
		return team_name;
	}


	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	

	public Integer getContributor_isUpload() {
		return contributor_isUpload;
	}


	public void setContributor_isUpload(Integer contributor_isUpload) {
		this.contributor_isUpload = contributor_isUpload;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	@Override
	public String toString() {
		return "Contributor [contributor_id=" + contributor_id + ", contributor_name=" + contributor_name
				+ ", contributor_password=" + contributor_password + ", contributor_phone=" + contributor_phone
				+ ", contributor_mail=" + contributor_mail + ", project_name=" + project_name + ", team_name="
				+ team_name + ", contributor_isUpload=" + contributor_isUpload + ", project=" + project + "]";
	}




	
}
