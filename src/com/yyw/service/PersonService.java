package com.yyw.service;

import java.util.List;

import com.yyw.entity.Person;

public interface PersonService {
	public Boolean addPerson(Person person);

	public List<Person> findTeamList(String teamName);
}
