package cn.hms.service.impl;

import java.util.List;


import cn.hms.dao.RoomDao;
import cn.hms.entity.Room;
import cn.hms.service.RoomBiz;

public class RoomBizImpl implements RoomBiz {

	private RoomDao roomDao;

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public List<Room> findNumberByType(int roomType) {
		return this.roomDao.selectNumber(roomType);
	}

	public int findType(String number) {
		return this.roomDao.selectType(number);
	}

	public List<Integer> findIdByifendId() {
		return this.roomDao.getRoomIdByifendId();
	}

	public void updateifendId() {
		this.roomDao.updateIfendId();
	}

	public int findId(String number) {
		return this.roomDao.getIdByNumber(number);
	}

	public List<Object[]> findRoomByidfendId(int pageNo, int pageSize) {
		return this.roomDao.getRoomByifendId(pageNo, pageSize);
	}

	public int findRoomCount() {
		return this.roomDao.getRoomCount();
	}

	public void updateifendIdById(int id) {
		this.roomDao.updateifendIdById(id);
	}

	public Room findRoomById(int id) {
		return this.roomDao.getRoomById(id);
	}

}
