package com.yyw.test;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yyw.dao.ContributorMapper;
import com.yyw.entity.Contributor;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-*.xml" })
public class judgeTest {

	@Autowired
	ContributorMapper contributorMapper;
	
	@Test
	public void runBy() {
		List<Contributor> all = contributorMapper.selectAll();

		System.out.println(all);
		for (Contributor contributor : all) {

			System.out.println(contributor);
		}
	}
	
	@Test
	public void testDemo(){
		List<Float> lList = new LinkedList<Float>();
		lList.add((float) 1.2);
		lList.add((float) 2.2);
		lList.add((float) 1.5);
		lList.add((float) 3.2);
		lList.add((float) 4.2);
		System.out.println(lList);
		//lList.remove(0);
		lList.remove(0);
		lList.add((float) 8.8);
		System.out.println(lList);
		
		
	}
	
}
