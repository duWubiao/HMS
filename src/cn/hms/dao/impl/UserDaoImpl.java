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
	 * 注册
	 */
	public void addUser(User user) {
		this.hibernateTemplate.save(user);
	}

	/**
	 * 通过真实姓名和电话号码查询用户
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
	 * 通过用户名查询用户
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
	 * 分页
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
	 * 查询总记录数
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
	 * 模糊查询分页
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
	 * 模糊查询总记录数
	 */
	public int getCountByLike(final String parma) {
		return (Integer) this.hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "select count(*) from User where username like ? and rid=1";// 这里的rid不是会员的意思是判断这条数据要不要查询出来(0为已经删除的,1是要查询出来的)
						Query query = session.createQuery(hql);
						query.setParameter(0, "%" + parma + "%");
						Long temp = (Long) query.uniqueResult();
						System.out.println(temp);
						return temp.intValue();// Long类型通过intValue()转换为int类型
					}
				});
	}

	/**
	 * 通过ID获取用户信息
	 */
	public User getUserById(int id) {
		User user = this.hibernateTemplate.get(User.class, id);
		return user;
	}

	/**
	 * 修改用户信息
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
	 * 通过id和密码查询数据
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
