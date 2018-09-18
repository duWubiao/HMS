package cn.hms.dao;

import java.util.List;

import cn.hms.entity.Room;

public interface RoomDao {
	/**
	 * 通过房间类型type查询房间号
	 */
	public List<Room> selectNumber(int roomType);

	/**
	 * 通过房号(number)查询类型(type)
	 */
	public int selectType(String number);
	
	/**
	 * 通过ifendId(0.空房间  1.有人入住)查询所有的空房间的id
	 */
	public List<Integer> getRoomIdByifendId();
	
	/**
	 * 把ifendId修改‘1’
	 */
	public void updateIfendId();
	
	/**
	 * 获取ID通过房间号(number)
	 * @param number
	 * @return
	 */
	public int getIdByNumber(String number);
	
	/**
	 * 查询所有的空房间通过ifendId=0
	 */
	public List<Object[]> getRoomByifendId(int pageNo,int pageSize);
	
	public int getRoomCount();
	
	/**
	 * 点击删除后空出房间ifendId=0
	 */
	public void updateifendIdById(int id);
	
	/*
	 *通过ID查询房间信息 
	 */
	public Room getRoomById(int id);
}
