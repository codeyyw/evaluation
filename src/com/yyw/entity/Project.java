package com.yyw.entity;

import java.util.List;

public class Project {


		private Integer project_id;
		
		private Integer c_id;
		
		private String project_name;
		private String project_type;
		private String project_team;
		private String project_key;
		private Integer project_patent;
		private String project_product;
		private String project_service;
		private float project_level;
		private List<String> fileNames;
		
		//记录评定过该项目的评委
		private List<Judge> judges;
  		
		
		public Project() {
			super();
		}
		public Project(Integer project_id,String project_name, String project_type, String project_team, String project_key,
				Integer project_patent, String project_product, String project_service, float project_level) {
			super();
			this.project_id = project_id;
			this.project_name = project_name;
			this.project_type = project_type;
			this.project_team = project_team;
			this.project_key = project_key;
			this.project_patent = project_patent;
			this.project_product = project_product;
			this.project_service = project_service;
			this.project_level = project_level;
		}
		
		
		
		public List<Judge> getJudges() {
			return judges;
		}
		public void setJudges(List<Judge> judges) {
			this.judges = judges;
		}
		public Integer getProject_id() {
			return project_id;
		}
		public void setProject_id(Integer project_id) {
			this.project_id = project_id;
		}

		
		public Integer getC_id() {
			return c_id;
		}
		public void setC_id(Integer c_id) {
			this.c_id = c_id;
		}
		public String getProject_name() {
			return project_name;
		}
		public void setProject_name(String project_name) {
			this.project_name = project_name;
		}
		public String getProject_type() {
			return project_type;
		}
		public void setProject_type(String project_type) {
			this.project_type = project_type;
		}
		public String getProject_team() {
			return project_team;
		}
		public void setProject_team(String project_team) {
			this.project_team = project_team;
		}
		public String getProject_key() {
			return project_key;
		}
		public void setProject_key(String project_key) {
			this.project_key = project_key;
		}
		public Integer getProject_patent() {
			return project_patent;
		}
		public void setProject_patent(Integer project_patent) {
			this.project_patent = project_patent;
		}
		public String getProject_product() {
			return project_product;
		}
		public void setProject_product(String project_product) {
			this.project_product = project_product;
		}
		public String getProject_service() {
			return project_service;
		}
		public void setProject_service(String project_service) {
			this.project_service = project_service;
		}
		public float getProject_level() {
			return project_level;
		}
		public void setProject_level(float project_level) {
			this.project_level = project_level;
		}
			
		public List<String> getFileNames() {
			return fileNames;
		}
		public void setFileNames(List<String> fileNames) {
			this.fileNames = fileNames;
		}
		
		
	@Override
		public String toString() {
			return "Project [project_id=" + project_id + ", c_id=" + c_id + ", project_name=" + project_name
					+ ", project_type=" + project_type + ", project_team=" + project_team + ", project_key="
					+ project_key + ", project_patent=" + project_patent + ", project_product=" + project_product
					+ ", project_service=" + project_service + ", project_level=" + project_level + ", fileNames="
					+ fileNames + ", judges=" + judges + "]";
		}
	@Override
	public boolean equals(Object obj) {
	
		
		if(obj instanceof Project) {
			Project p = (Project)obj;
			if(p.getC_id()==this.getC_id()&&p.getProject_patent()==this.getProject_patent()&&p.getProject_level()==this.getProject_level()&&p.getProject_key().equals(this.getProject_key())&&p.getProject_product().equals(this.getProject_product())&&p.getProject_service().equals(this.getProject_service()))
			return true;
		}
	return super.equals(obj);
	}
		
		
}
