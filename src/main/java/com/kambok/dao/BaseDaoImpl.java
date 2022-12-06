package com.kambok.dao;

import com.kambok.pojo.AppointDetails;
import com.kambok.pojo.User;
import com.kambok.util.HibernateUtil;
import com.kambok.util.HibernateUtil2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BaseDaoImpl implements BaseDao {
	
@Override

public boolean login(String username, String password) {
 Session session = HibernateUtil.getSession();
 if (session != null) {
  try {
   User user = (User) session.get(User.class, username);

   if (password.equals(user.getPassword())) {
    System.out.println("User: " + user.toString());
    return true;
   }
  } catch (Exception exception) {
   System.out.println("Exception occred while reading user data: "
     + exception.getMessage());
   return false;
  }

 } else {
  System.out.println("DB server down.....");
 }
 return false;
}


public String getposition(String username) {
	 Session session = HibernateUtil.getSession();
	
	 if (session != null) {
		  try {
		   User user = (User) session.get(User.class, username);
		
		   if (username.equals(user.getUsername())) {
		    System.out.println("position: " + user.toString());
		    return user.getLastName();
		   }else {
			   return "nil";
		   }
		  } catch (Exception exception) {
		   System.out.println("Exception occred while reading user data: "
		     + exception.getMessage());
		
		  }

		 } else {
		  System.out.println("DB server down.....");
		 }
	return "nil";
}

@Override
public String register(User user) {
 String msg = "Registration unsuccessful, try again.....";
 Session session = HibernateUtil.getSession();
 if (session != null) {
  try {
   if (user != null) {
    String username = (String) session.save(user);
    session.beginTransaction().commit();
    msg = "User " + username
      + " created successfully, please login...";
   }
  } catch (Exception exception) {
   System.out.println("Exception occred while reading user data: "
     + exception.getMessage());
  }

 } else {
  System.out.println("DB server down.....");
 }
 System.out.println("msg:" + msg);
 return msg;
}


@Override
public String appointment(AppointDetails ap) {
	 String msg = "appointment not successful, try again.....";
	 Session session = HibernateUtil2.getSession();
	 if (session != null) {
	  try {
	   if (ap != null) {
	    String username = (String) session.save(ap);
	    session.beginTransaction().commit();
	    msg = "User " + username
	      + " created appointment booked, please wait...";
	   }
	  } catch (Exception exception) {
	   System.out.println("Exception occred while reading user data: "
	     + exception.getMessage());
	  }

	 } else {
	  System.out.println("DB server down.....");
	 }
	 System.out.println("msg:" + msg);
	 return msg;
	}

public String updateUser(User user,String username) {
	String msg = "Updating  unsuccessful, try again.....";
	 Session session = HibernateUtil.getSession();
	 if (session != null) {
	  try {
	   if (user != null) {
		   Transaction t=session.beginTransaction();
	
	        User us=session.get(User.class, username);
	        us.setPassword(user.getPassword());
	
	        session.save(us);
	        t.commit();  
	
	
	    msg = "User " + username
	      + " updated successfully";
	
	   }
	  } catch (Exception exception) {
	   System.out.println("Exception occred while reading user data: "
	     + exception.getMessage());
	  }

	 } else {
	  System.out.println("DB server down.....");
	 }
	 System.out.println("msg:" + msg);
	 return msg;	
	
}


public String deleteUser(String username) {

	String msg = "deleting  unsuccessful, try again.....";
	 Session session = HibernateUtil.getSession();
	 if (session != null) {
	  try {
	   if (username != null) {
		   Transaction t=session.beginTransaction();
	
		   User us=session.get(User.class, username);
	        session.delete(us);
	        t.commit();
	
	
	    msg = "User " + username
	      + " updated successfully";
	
	   }
	  } catch (Exception exception) {
	   System.out.println("Exception occred while reading user data: "
	     + exception.getMessage());
	  }

	 } else {
	  System.out.println("DB server down.....");
	 }
	 System.out.println("msg:" + msg);
	 return msg;
	
}
	


	}
