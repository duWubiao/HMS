package cn.hms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hms.dao.LivereCordDao;
import cn.hms.entity.Liverecord;

public class LivereCordDaoImpl implements LivereCordDao {

	private HibernateTemplate hibernateTemplate;
	
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}


	public void addLive(Liverecord live) {
		this.hibernateTemplate.save(live);
	}


	public List<Integer> getRoomIdByifendId() {
		
		return this.hibernateTemplate.execute(new HibernateCallback<List<Integer>>() {
			public List<Integer> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select live.roomId from Liverecord live where live.ifendId=1";
				Query query = session.createSQLQuery(sql);
				return query.list();
			}
		});
	}


	public List<Liverecord> getLiveByifendId(final int pageIndex,final int pageSize) {		
		return this.hibernateTemplate.execute(new HibernateCallback<List<Liverecord>>() {
			public List<Liverecord> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from Liverecord where ifendId=1");
				query.setFirstResult((pageIndex-1)*pageSize);
				query.setMaxResults(pageSize);
				return query.list();
			}
		});
	}


	public int getCount() {
		return (Integer)this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select count(*) from Liverecord where ifendId=1";
				Query query = session.createQuery(sql);
				Long temp = (Long) query.uniqueResult();
				return temp.intValue();
			}
		});
	}


	public List<Liverecord> getLiveByifendIdLike(final String parma, final int pageIndex,final int pageSize) {
		
		return this.hibernateTemplate.execute(new HibernateCallback<List<Liverecord>>() {	
			public List<Liverecord> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from Liverecord where name like ? and ifendId=1";
				Query query = session.createQuery(hql);
				query.setParameter(0, "%"+parma+"%");
				query.setFirstResult((pageIndex-1)*pageSize);
				query.setMaxResults(pageSize);
				List<Liverecord> liveList = query.list();
				for (Liverecord live : liveList) {
					System.out.println(live.getName());
				}
				return liveList;
			}
		});
	}


	public int getCountLike(final String parma) {
		return (Integer)this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "select count(*) from Liverecord where name like ? and ifendId=1";
				Query query = session.createQuery(hql);
				query.setParameter(0, "%"+parma+"%");
				Long temp = (Long) query.uniqueResult();
				System.out.println(temp);
				return temp.intValue();//Long类型通过intValue()转换为int类型
			}
		});
	}

	public void deleteLive(int id) {
		Liverecord lives = this.getLive(id);
		lives.setIfendId(0);	
		this.hibernateTemplate.update(lives);
	}


	public Liverecord getLive(int id) {
		Liverecord live = this.hibernateTemplate.get(Liverecord.class,id);
		return live;
	}
}
