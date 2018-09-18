package cn.hms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hms.dao.UserDao;
import cn.hms.entity.Liverecord;
import cn.hms.entity.Md5;
import cn.hms.entity.Room;
import cn.hms.entity.User;

public class UserDaoImpl implements UserDao {

	Md5 md5 = new Md5();
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public User selectUser(String username, String password) {
		List<User> userList = this.hibernateTemplate.find(
				"from User u where u.username=? and u.password=?", username,
				password);
		if (userList.size() > 0)
			return userList.get(0);
		else
			return null;
	}

	/**
	 * ע��
	 */
	public void addUser(User user) {
		this.hibernateTemplate.save(user);
	}

	/**
	 * ͨ����ʵ�����͵绰�����ѯ�û�
	 */
	public User selectUser_2(String name, String phone) {
		List<User> userList = this.hibernateTemplate.find(
				"from User u where u.name=? and u.phone=?", name, phone);
		if (userList.size() > 0) {
			return userList.get(0);
		}
		return null;
	}

	/**
	 * ͨ���û�����ѯ�û�
	 */
	public User getUsername(String username) {
		List<User> list = this.hibernateTemplate.find(
				"from User u where u.username=?", username);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	/*
	 * ��ҳ
	 * 
	 * @see cn.hms.dao.UserDao#getUserList(int, int)
	 */
	public List<User> getUserList(final int pageNo, final int pageSize) {
		return this.hibernateTemplate
				.execute(new HibernateCallback<List<User>>() {

					public List<User> doInHibernate(Session session)
							throws HibernateException, SQLException {
						// TODO Auto-generated method stub
						Query query = session.createQuery("from User where rid=1");
						query.setFirstResult((pageNo - 1) * pageSize);
						query.setMaxResults(pageSize);
						List<User> userList = query.list();
						for (User user : userList) {
							System.out.println(user.getUsername()
									+ ";;;;;;;;;;");
						}
						return userList;
					}
				});
	}

	/**
	 * ��ѯ�ܼ�¼��
	 */
	public int getCount() {
		return (Integer) this.hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String sql = "select count(*) from User where rid=1";
						Query query = session.createQuery(sql);
						Long temp = (Long) query.uniqueResult();
						return temp.intValue();
					}
				});
	}

	/**
	 * ģ����ѯ��ҳ
	 */
	public List<User> getUserListByLike(final String parma, final int pageNo,
			final int pageSize) {
		return this.hibernateTemplate
				.execute(new HibernateCallback<List<User>>() {
					public List<User> doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from User where username like ? and rid=1";
						Query query = session.createQuery(hql);
						query.setParameter(0, "%" + parma + "%");
						query.setFirstResult((pageNo - 1) * pageSize);
						query.setMaxResults(pageSize);
						List<User> userList = query.list();
						// for (User user : userList) {
						// System.out.println(user.getName());
						// }
						return userList;
					}
				});
	}

	/**
	 * ģ����ѯ�ܼ�¼��
	 */
	public int getCountByLike(final String parma) {
		return (Integer) this.hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "select count(*) from User where username like ? and rid=1";// �����rid���ǻ�Ա����˼���ж���������Ҫ��Ҫ��ѯ����(0Ϊ�Ѿ�ɾ����,1��Ҫ��ѯ������)
						Query query = session.createQuery(hql);
						query.setParameter(0, "%" + parma + "%");
						Long temp = (Long) query.uniqueResult();
						System.out.println(temp);
						return temp.intValue();// Long����ͨ��intValue()ת��Ϊint����
					}
				});
	}

	/**
	 * ͨ��ID��ȡ�û���Ϣ
	 */
	public User getUserById(int id) {
		User user = this.hibernateTemplate.get(User.class, id);
		return user;
	}

	/**
	 * �޸��û���Ϣ
	 */
	public void updateUser(User user) {
		User users = this.hibernateTemplate.get(User.class, user.getId());
		users.setUsername(user.getUsername());
		users.setName(user.getName());
		users.setIdCard(user.getIdCard());
		users.setPhone(user.getPhone());
		users.setRegtime(user.getRegtime());
		this.hibernateTemplate.update(users);
	}

	/**
	 * ͨ��id�������ѯ����
	 */
	public User selectPwd(int id,String password) {
		List<User> userList = this.hibernateTemplate.find("from User where password=? and id=?",password,id);
		System.out.println(userList.size());
		if(userList.size() > 0){
			for (User user : userList) {
				System.out.println(user.getUsername());
			}
			return userList.get(0);
		}
		//System.out.println("aaaaaaaa");
		return null;
	}

	public int updatePwd(final User user) {
		return (Integer)this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				//System.out.println(user.getId()+"111111111111111");
				String sql = "update user set password=? where id=?";
				Query query = session.createSQLQuery(sql);
				query.setParameter(0,user.getPassword());
				query.setParameter(1, user.getId());
				int k = query.executeUpdate();
				//System.out.println(k+"kkkkkkkkkk");
				return k;
			}
		});
	}

	public void deleteUser(int id) {
		User user = this.hibernateTemplate.get(User.class, id);
		user.setRid(0);
		this.hibernateTemplate.update(user);
	}
}
