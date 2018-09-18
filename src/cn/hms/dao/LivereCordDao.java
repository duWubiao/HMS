package cn.hms.dao;

import java.util.List;

import cn.hms.entity.Liverecord;

public interface LivereCordDao {

	/**
	 * ԤԼ
	 * @param live
	 */
	public void addLive(Liverecord live);
	
	/**
	 * ͨ��ifendId��ȡ����id
	 * @return
	 */
	public List<Integer> getRoomIdByifendId();
	
	/**
	 * ��ҳ
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Liverecord> getLiveByifendId(int pageIndex,int pageSize);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 */
	public int getCount();
	/**
	 * ��ȡ�ܼ�¼��
	 * @return
	 */
	public int getCountLike(String parma);
	
	/**
	 * ģ����ѯ��ҳ
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Liverecord> getLiveByifendIdLike(String parma,int pageIndex,int pageSize);
	
	/**
	 * ��ɾ��
	 */
	public void deleteLive(int id);
	
	/**
	 * ͨ��ID��ѯ����
	 */
	public Liverecord getLive(int id);
}
