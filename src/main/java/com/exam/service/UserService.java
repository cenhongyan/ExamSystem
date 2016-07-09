package com.exam.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.exam.dao.UserDao;
import com.exam.entity.User;

@Service
public class UserService {
	@Resource
	UserDao userDao;
	
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}

}