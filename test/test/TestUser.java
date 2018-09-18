package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hms.dao.UserDao;
import cn.hms.entity.Room;
import cn.hms.entity.User;
import cn.hms.service.LivereCordBiz;
import cn.hms.service.UserBiz;


public class TestUser {
	  @Test
	  public void testUserDao1(){
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	  UserDao userDao = (UserDao) ctx.getBean("userDao");	
    	  User user = userDao.selectUser("admin", "admin");
    	  if(user != null)
    		  System.out.println("=========================================="+user.getUsername());
	 }
	 @Test
	 public void testAddUser(){
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		 UserBiz userBiz = (UserBiz) ctx.getBean("userBiz");
		 User user = (User) ctx.getBean("user");
		 user.setUsername("张三");
		 user.setPassword("123456");
		 user.setName("老张");
		 user.setIdCard("362502136549412");		 
		 user.setUserId(3);		 
//		 Date date = new Date();
//		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		 String f = format.format(date);
		 user.setRegtime(new Date());
		 user.setPhone("13869423126");
		 user.setRid(1);
		 userBiz.register(user);
	 }
	  @Test
	  public void testUserList(){
		  ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	  UserDao userDao = (UserDao) ctx.getBean("userDao");	
    	  List<User> userList = userDao.getUserList(2, 5);
    	  
//    	  List<User> userList = userDao.getUserListByLike("小", 1, 1);
    	  for (User user : userList) {
			System.out.println(user.getUsername());
		}
	  }
	  @Test
		public void testGetCountByLike(){
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			UserDao userDao = (UserDao) context.getBean("userDao");
			int k = userDao.getCountByLike("q");
			System.out.println(k);
		}
	  @Test
			public void testGetUserById(){
				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				UserDao userDao = (UserDao) context.getBean("userDao");
				User user = userDao.getUserById(1);
				System.out.println(user.getName());
	  }
	 
}
