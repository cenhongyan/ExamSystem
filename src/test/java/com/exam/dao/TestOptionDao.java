package com.exam.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exam.entity.Option;

public class TestOptionDao {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	OptionDao optionDao = (OptionDao) applicationContext.getBean("optionDao");
	
	@Test
	public void countRadioQuestoinNumber(){
		List<Option> options = optionDao.selectAll();
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		char c = 'A';
		int last = -1;
		for (Option option:options){
			System.out.println(option.getQid());
			if (option.getQid() != last){
				c ='A';			
			}
			option.setSymbol(String.valueOf(c++));
			last = option.getQid();
			
			if (option.getIsTrue() == 1)
			if (map.get(option.getQid())==null){
				map.put(option.getQid(),1);
			}else{
				map.replace(option.getQid(), map.get(option.getQid())+1);
			}
			optionDao.update(option);
		}
	}
	
	@Test
	public void testUpdateOption(){
		Option option = optionDao.selectById(27);
		option.setSymbol("A");
//		optionDao.update(option);
	}
	
	@Test
	public void testInsertOption(){
		Option option = new Option();
		option.setSymbol("A");
		option.setTitle("是");
		option.setQid(346);
//		optionDao.insertOption(option);
		System.out.println(optionDao.selectByQid(346));
	}
}
