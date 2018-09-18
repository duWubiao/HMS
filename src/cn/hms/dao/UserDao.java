package cn.hms.dao;


import java.util.List;

import cn.hms.entity.User;

public interface UserDao {
	
	/**
	 * 添加用户信息
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User selectUser(String username, String password);
	
	/**
	 * 通过真实姓名和电话号码查询，判断是否为会员
	 * @param name
	 * @return
	 */
	public User selectUser_2(String name,String phone);
	
	/**
	 * 异步判断用户名不能重复
	 * @param username
	 * @return
	 */
	public User getUsername(String username);
	
	/**
	 * 获取所有用户信息
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUserList(int pageNo,int pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getCount();
	
	/**
	 * 获取总记录数(模糊查询)
	 * @return
	 */
	public int getCountByLike(String parma);
	
	/**
	 * 获取所有用户信息(模糊查询)
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUserListByLike(String parma,int pageNo,int pageSize);
	
	/*
	 * 通过ID查询信息
	 */
	public User getUserById(int id);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 通过id和密码查询数据
	 */
	public User selectPwd(int id,String password);
	
	/**
	 * 修改密码
	 */
	public int updatePwd(User user);
	
	/**
	 * 假删除用户
	 */
	public void deleteUser(int id);
}