package com.kambok.service;

import com.kambok.pojo.AppointDetails;
import com.kambok.pojo.User;

public interface BaseService {

       public boolean login(String username, String password);

		 public String registration(User user);
		
		 public String getposition(String username);
		
		 public String appointment(AppointDetails ap);
		 public String updateUser(User us,String username);
		 public String deleteUser(String username);
			}

