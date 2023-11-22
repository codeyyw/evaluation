package com.yyw.dao;

import java.util.List;

import com.yyw.entity.Person;

public interface PersonMapper {

	//添加团队成员
	public Integer insertPerson(Person person);

	//查找所有团队成员
	public List<Person> selectAll(String teamName);

}
