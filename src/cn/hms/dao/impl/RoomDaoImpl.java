package cn.hms.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hms.dao.RoomDao;
import cn.hms.entity.Room;
import cn.hms.entity.Roomtype;

public class RoomDaoImpl implements RoomDao{

	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<Room> selectNumber(int roomType) {
		String hql = "from Room r where r.type=? and r.ifendId=0";
		List<Room> roomList = this.hibernateTemplate.find(hql,roomType);
		for (Room room : roomList) {
			System.out.println(room.getNumber());
		}
		return roomList;
	}

	public int selectType(final String number) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select r.type from Room r where r.number=?";
				Query query = session.createSQLQuery(sql);
				query.setParameter(0, number);
				int k = (Integer) query.uniqueResult();
				return k;
			}
		});
	}

	public List<Integer> getRoomIdByifendId() {
		return this.hibernateTemplate.execute(new HibernateCallback<List<Integer>>() {
			public List<Integer> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select r.id from Room r where r.ifendId=0";
				Query query = session.createSQLQuery(sql);			
				return query.list();
			}
		});
	}

	public void updateIfendId() {
		this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "update Room r,Liverecord live set r.ifendId=1 where r.id=live.roomId and live.ifendId=1";
				Query query = session.createSQLQuery(sql);
				return query.executeUpdate();
			}
		});
	}

	public int getIdByNumber(final String number) {
		return this.hibernateTemplate.execute(new HibernateCallback<Integer>() {
			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select r.id from Room r where r.number=?";
				Query query = session.createSQLQuery(sql);
				query.setParameter(0, number);
				int k = (Integer) query.uniqueResult();
				return k;
			}
		});
	}

	public List<Object[]> getRoomByifendId(final int pageNo, final int pageSize) {		
		return this.hibernateTemplate.execute(new HibernateCallback<List<Object[]>>() {
			public List<Object[]> doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select r.*,t.dayPrice from Room r , Roomtype t where r.type=t.type";
				Query query = session.createSQLQuery(sql)
						.addEntity(Room.class)
						.addEntity(Roomtype.class)
						.setFirstResult((pageNo-1)*pageSize)
						.setMaxResults(pageSize);
				return query.list();
			}
		});
	}

	public int getRoomCount() {
		return (Integer)this.hibernateTemplate.execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select count(*) from Room where ifendId=0";
				Query query = session.createQuery(sql);
				Long temp = (Long) query.uniqueResult();
				return temp.intValue();
			}
		});
	}

	public void updateifendIdById(int id) {
		Room room = this.hibernateTemplate.get(Room.class, id);
		room.setIfendId(0);
		this.hibernateTemplate.update(room);
	}

	public Room getRoomById(int id) {
		List<Room> list = this.hibernateTemplate.find("from Room where id=? and ifendId=1",id);
		if(list.size() > 0){
			return list.get(0);
		}
		return null;
	}

}
