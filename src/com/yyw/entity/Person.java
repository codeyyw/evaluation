package com.yyw.entity;

public class Person {
	private int person_id;
	private String person_name;
	private String person_sex;
	private Integer person_old;
	private String person_college;
	private String person_degree;
	private String person_position;
	private String person_profession;
	private Integer person_jobYear;
	private String person_team;
	public Person() {
		super();
	}
	public Person(int person_id, String person_name, String person_sex, Integer person_old, String person_college,
			String person_degree, String person_position, String person_profession, Integer person_jobYear,
			String person_team) {
		super();
		this.person_id = person_id;
		this.person_name = person_name;
		this.person_sex = person_sex;
		this.person_old = person_old;
		this.person_college = person_college;
		this.person_degree = person_degree;
		this.person_position = person_position;
		this.person_profession = person_profession;
		this.person_jobYear = person_jobYear;
		this.person_team = person_team;
	}
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getPerson_sex() {
		return person_sex;
	}
	public void setPerson_sex(String person_sex) {
		this.person_sex = person_sex;
	}
	public Integer getPerson_old() {
		return person_old;
	}
	public void setPerson_old(Integer person_old) {
		this.person_old = person_old;
	}
	public String getPerson_college() {
		return person_college;
	}
	public void setPerson_college(String person_college) {
		this.person_college = person_college;
	}
	public String getPerson_degree() {
		return person_degree;
	}
	public void setPerson_degree(String person_degree) {
		this.person_degree = person_degree;
	}
	public String getPerson_position() {
		return person_position;
	}
	public void setPerson_position(String person_position) {
		this.person_position = person_position;
	}
	public String getPerson_profession() {
		return person_profession;
	}
	public void setPerson_profession(String person_profession) {
		this.person_profession = person_profession;
	}
	public Integer getPerson_jobYear() {
		return person_jobYear;
	}
	public void setPerson_jobYear(Integer person_jobYear) {
		this.person_jobYear = person_jobYear;
	}
	public String getPerson_team() {
		return person_team;
	}
	public void setPerson_team(String person_team) {
		this.person_team = person_team;
	}
	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name=" + person_name + ", person_sex=" + person_sex
				+ ", person_old=" + person_old + ", person_college=" + person_college + ", person_degree="
				+ person_degree + ", person_position=" + person_position + ", person_profession=" + person_profession
				+ ", person_jobYear=" + person_jobYear + ", person_team=" + person_team + "]";
	}
	
	
	
	
}
