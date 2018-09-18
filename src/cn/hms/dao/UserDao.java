package cn.hms.dao;


import java.util.List;

import cn.hms.entity.User;

public interface UserDao {
	
	/**
	 * ����û���Ϣ
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * ��¼
	 * @param username
	 * @param password
	 * @return
	 */
	public User selectUser(String username, String password);
	
	/**
	 * ͨ����ʵ�����͵绰�����ѯ���ж��Ƿ�Ϊ��Ա
	 * @param name
	 * @return
	 */
	public User selectUser_2(String name,String phone);
	
	/**
	 * �첽�ж��û��������ظ�
	 * @param username
	 * @return
	 */
	public User getUsername(String username);
	
	/**
	 * ��ȡ�����û���Ϣ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUserList(int pageNo,int pageSize);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 */
	public int getCount();
	
	/**
	 * ��ȡ�ܼ�¼��(ģ����ѯ)
	 * @return
	 */
	public int getCountByLike(String parma);
	
	/**
	 * ��ȡ�����û���Ϣ(ģ����ѯ)
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUserListByLike(String parma,int pageNo,int pageSize);
	
	/*
	 * ͨ��ID��ѯ��Ϣ
	 */
	public User getUserById(int id);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * ͨ��id�������ѯ����
	 */
	public User selectPwd(int id,String password);
	
	/**
	 * �޸�����
	 */
	public int updatePwd(User user);
	
	/**
	 * ��ɾ���û�
	 */
	public void deleteUser(int id);
}