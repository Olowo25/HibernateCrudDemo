package com.kambok.service;

import com.kambok.dao.BaseDao;
import com.kambok.dao.BaseDaoImpl;
import com.kambok.pojo.AppointDetails;
import com.kambok.pojo.User;

public class BaseServiceImpl implements BaseService {

	 private BaseDao loginDao = new BaseDaoImpl();

	 @Override
	 public boolean login(String username, String password) {
	  return loginDao.login(username, password);
	 }

	 @Override
	 public String registration(User user) {
	  return loginDao.register(user);
	 }
	
	 @Override
	 public String getposition(String username) {
		
		 return loginDao.getposition(username);
	 }
	
	 @Override
	 public String appointment(AppointDetails ap) {
		
		 return loginDao.appointment(ap).toString();
	 }
	

	 public String updateUser(User us,String username) {
		return loginDao.updateUser(us, username); 
	 }
	 public String deleteUser(String username) {
		
		return loginDao.deleteUser(username); 
	 }
	}
