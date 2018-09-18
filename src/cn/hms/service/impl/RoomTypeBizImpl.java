package cn.hms.service.impl;

import cn.hms.dao.RoomTypeDao;
import cn.hms.service.RoomTypeBiz;

public class RoomTypeBizImpl implements RoomTypeBiz {

	private RoomTypeDao roomTypeDao;
	
	public void setRoomTypeDao(RoomTypeDao roomTypeDao) {
		this.roomTypeDao = roomTypeDao;
	}

	public int findPriceByType(int type) {
		return this.roomTypeDao.selectPrice(type);
	}

}
