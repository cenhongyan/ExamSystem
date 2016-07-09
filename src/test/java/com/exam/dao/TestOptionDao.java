package com.exam.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exam.entity.Option;
import com.exam.service.QuestionService;
import com.sun.javafx.collections.MappingChange.Map;

public class TestOptionDao {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	OptionDao optionDao = (OptionDao) applicationContext.getBean("optionDao");
	
	@Test
	public void countRadioQuestoinNumber(){
		List<Option> options = optionDao.selectAll();
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for (Option option:options){
			if (option.getIsTrue() == 1)
			if (map.get(option.getQid())==null){
				map.put(option.getQid(),1);
			}else{
				map.replace(option.getQid(), map.get(option.getQid())+1);
			}
		}
		int count = 0;
		for (Entry<Integer, Integer> key:map.entrySet()){
			if (key.getValue() == 1){
				count++;
			}
		}
		System.out.println(map.size());
	}
}