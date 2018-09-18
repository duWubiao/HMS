package cn.hms.service;


import java.util.List;

import cn.hms.entity.User;

public interface UserBiz {
	
	public User findUser(String name, String password);
	
	public void register(User user);
	
	public User findUser_2(String name,String phone);
	
	public User findUserByUsername(String username);
	
	public List<User> findUserList(int pageNo,int pageSize);
	
	public int findCount();
	
	public int findCountByLike(String parma);
	
	public List<User> findUserListByLike(String parma,int pageNo,int pageSize);
	
	public User findUserById(int id);
	
	public void updateUser(User user);
	
	public User selectUserByPwdandId(int id,String password);
	
	public int updatePwd(User user);
	
	public void deleteUser(int id);
}