package com.yyw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yyw.dao.PersonMapper;
import com.yyw.entity.Person;
import com.yyw.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonMapper personMapper;
	

	public PersonMapper getPersonMapper() {
		return personMapper;
	}


	public void setPersonMapper(PersonMapper personMapper) {
		this.personMapper = personMapper;
	}


	@Override
	public Boolean addPerson(Person person) {
		Boolean result = false;
		
		result = personMapper.insertPerson(person)>0 ?true:false;
		return result;
	}


	@Override
	public List<Person> findTeamList(String teamName) {
		List<Person>  teamList = null;
		teamList = personMapper.selectAll(teamName);
		
		if(teamList!=null) {
			
			System.out.println("查询成功"+teamList);
		}
		return teamList;
	}

}
