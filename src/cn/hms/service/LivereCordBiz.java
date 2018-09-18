package cn.hms.service;

import java.util.List;

import cn.hms.entity.Liverecord;

public interface LivereCordBiz {

	public void saveLive(Liverecord live);
	
	public List<Integer> findRoomIdByifendId();
	
	public List<Liverecord> findLivesByifendId(int pageIndex,int pageSize);
	
	public int findCount();
	
	public int findCountByLike(String parma);
	
	public List<Liverecord> findLivesByifendIdLike(String parma,int pageIndex,int pageSize);
	
	public void deleteLive(int id);
	
	public Liverecord findLive(int id);
}
