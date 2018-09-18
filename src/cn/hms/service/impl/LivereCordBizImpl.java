package cn.hms.service.impl;

import java.util.List;

import cn.hms.dao.LivereCordDao;
import cn.hms.entity.Liverecord;
import cn.hms.service.LivereCordBiz;

public class LivereCordBizImpl implements LivereCordBiz {

	private LivereCordDao liveDao;
	
	

	public void setLiveDao(LivereCordDao liveDao) {
		this.liveDao = liveDao;
	}



	public void saveLive(Liverecord live) {
		this.liveDao.addLive(live);
	}



	public List<Integer> findRoomIdByifendId() {
		return this.liveDao.getRoomIdByifendId();
	}

	public List<Liverecord> findLivesByifendId(int pageIndex, int pageSize) {
		return this.liveDao.getLiveByifendId(pageIndex, pageSize);
	}

	public int findCount() {
		return this.liveDao.getCount();
	}

	public List<Liverecord> findLivesByifendIdLike(String parma, int pageIndex,
			int pageSize) {
		return this.liveDao.getLiveByifendIdLike(parma, pageIndex, pageSize);
	}

	public int findCountByLike(String parma) {
		return this.liveDao.getCountLike(parma);
	}

	public void deleteLive(int id) {
		this.liveDao.deleteLive(id);
	}



	public Liverecord findLive(int id) {
		return this.liveDao.getLive(id);
	}

}
