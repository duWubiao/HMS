package cn.hms.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hms.dao.RoomTypeDao;

public class RoomTypeImpl implements RoomTypeDao {

	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	public int selectPrice(final int type) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select t.dayPrice from RoomType t where t.type=?";
				Query query = session.createSQLQuery(sql);
				query.setParameter(0, type);
				int k = (Integer) query.uniqueResult();
				return k;
			}
		});
	}
	
}
