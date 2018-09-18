package cn.hms.dao;

import java.util.List;

import cn.hms.entity.Room;

public interface RoomDao {
	/**
	 * ͨ����������type��ѯ�����
	 */
	public List<Room> selectNumber(int roomType);

	/**
	 * ͨ������(number)��ѯ����(type)
	 */
	public int selectType(String number);
	
	/**
	 * ͨ��ifendId(0.�շ���  1.������ס)��ѯ���еĿշ����id
	 */
	public List<Integer> getRoomIdByifendId();
	
	/**
	 * ��ifendId�޸ġ�1��
	 */
	public void updateIfendId();
	
	/**
	 * ��ȡIDͨ�������(number)
	 * @param number
	 * @return
	 */
	public int getIdByNumber(String number);
	
	/**
	 * ��ѯ���еĿշ���ͨ��ifendId=0
	 */
	public List<Object[]> getRoomByifendId(int pageNo,int pageSize);
	
	public int getRoomCount();
	
	/**
	 * ���ɾ����ճ�����ifendId=0
	 */
	public void updateifendIdById(int id);
	
	/*
	 *ͨ��ID��ѯ������Ϣ 
	 */
	public Room getRoomById(int id);
}
