package cn.hms.dao;

import java.util.List;

import cn.hms.entity.Liverecord;

public interface LivereCordDao {

	/**
	 * 预约
	 * @param live
	 */
	public void addLive(Liverecord live);
	
	/**
	 * 通过ifendId获取主键id
	 * @return
	 */
	public List<Integer> getRoomIdByifendId();
	
	/**
	 * 分页
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Liverecord> getLiveByifendId(int pageIndex,int pageSize);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getCount();
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getCountLike(String parma);
	
	/**
	 * 模糊查询分页
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Liverecord> getLiveByifendIdLike(String parma,int pageIndex,int pageSize);
	
	/**
	 * 假删除
	 */
	public void deleteLive(int id);
	
	/**
	 * 通过ID查询数据
	 */
	public Liverecord getLive(int id);
}
