package cn.hms.service.impl;
import java.util.List;

import cn.hms.dao.UserDao;

import cn.hms.entity.User;
import cn.hms.service.UserBiz;

public class UserBizImpl implements UserBiz {
	private UserDao userDao;
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User findUser(String name, String password) {
		return userDao.selectUser(name, password);
	}

	public void register(User user) {
		this.userDao.addUser(user);
	}

	public User findUser_2(String name, String phone) {
		return this.userDao.selectUser_2(name, phone);
	}

	public User findUserByUsername(String username) {
		return this.userDao.getUsername(username);
	}

	public List<User> findUserList(int pageNo, int pageSize) {
		return this.userDao.getUserList(pageNo, pageSize);
	}

	public int findCount() {
		return this.userDao.getCount();
	}

	public int findCountByLike(String parma) {
		return this.userDao.getCountByLike(parma);
	}

	public List<User> findUserListByLike(String parma, int pageNo, int pageSize) {
		return this.userDao.getUserListByLike(parma, pageNo, pageSize);
	}

	public User findUserById(int id) {
		return this.userDao.getUserById(id);
	}

	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}

	public User selectUserByPwdandId(int id, String password) {
		return this.userDao.selectPwd(id, password);
	}

	public int updatePwd(User user) {
		return this.userDao.updatePwd(user);
	}

	public void deleteUser(int id) {
		this.userDao.deleteUser(id);
	}

}
