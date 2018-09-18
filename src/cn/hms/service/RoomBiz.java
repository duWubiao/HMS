package cn.hms.service;

import java.util.List;

import cn.hms.entity.Room;

public interface RoomBiz {

	public List<Room> findNumberByType(int roomType);
	
	public int findType(String number);
	
	public List<Integer> findIdByifendId();
	
	public void updateifendId();
	
	public int findId(String number);
	
	public List<Object[]> findRoomByidfendId(int pageNo,int pageSize);
	
	public int findRoomCount();
	
	public void updateifendIdById(int id);
	
	public Room findRoomById(int id);
}
