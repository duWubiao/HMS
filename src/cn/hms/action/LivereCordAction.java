package cn.hms.action;

import java.io.UnsupportedEncodingException;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.hms.entity.Liverecord;
import cn.hms.entity.User;

import cn.hms.entity.Room;
import cn.hms.service.LivereCordBiz;
import cn.hms.service.RoomBiz;
import cn.hms.service.RoomTypeBiz;
import cn.hms.service.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LivereCordAction extends ActionSupport {

	private LivereCordBiz liveBiz;
	private Room room;
	private Liverecord live;
	private RoomBiz roomBiz;
	private UserBiz userBiz;
	ActionContext ac = ActionContext.getContext();
	Map<String, Object> session = ac.getSession();

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String parma;

	public String getParma() {
		return parma;
	}

	public void setParma(String parma) {
		this.parma = parma;
	}

	private int pageIndexLike;

	public int getPageIndexLike() {
		return pageIndexLike;
	}

	public void setPageIndexLike(int pageIndexLike) {
		this.pageIndexLike = pageIndexLike;
	}

	private int pageIndex;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	private RoomTypeBiz roomTypeBiz;

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	public void setRoomTypeBiz(RoomTypeBiz roomTypeBiz) {
		this.roomTypeBiz = roomTypeBiz;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setLiveBiz(LivereCordBiz liveBiz) {
		this.liveBiz = liveBiz;
	}

	public Liverecord getLive() {
		return live;
	}

	public void setLive(Liverecord live) {
		this.live = live;
	}

	public String make() {
		User user = this.userBiz.findUser_2(live.getName(), live.getPhone());
		int type = this.roomBiz.findType(room.getNumber());
		int price = this.roomTypeBiz.findPriceByType(type);
		int roomId = this.roomBiz.findId(room.getNumber());
		if (user != null) {
			live.setRid(2);
			live.setPrice(((price * live.getDay()) * 90) / 100);
			System.out.println();
		} else {
			live.setRid(3);
			live.setPrice(price * live.getDay());
		}
		live.setRoomId(roomId);
		live.setIfendId(1);
		live.setRegtime(new Date());
		this.liveBiz.saveLive(live);
		this.roomBiz.updateifendId();
		return SUCCESS;
	}

	public String fenyes() {
		int pageindex = 1;
		if (this.pageIndex != 0) {
			pageindex = pageIndex;
		}
		int count = this.liveBiz.findCount();
		int pageSize = 5;
		int pageCount = (count % pageSize == 0) ? (count / pageSize) : (count
				/ pageSize + 1);
		if (pageindex < 1) {
			pageindex = 1;
		} else if (pageindex > pageCount) {
			pageindex = pageCount;
		}
		List<Liverecord> liveList = this.liveBiz.findLivesByifendId(pageindex,
				pageSize);
		if (liveList != null) {
			int flag = 0;
			session.put("flag", flag);
			session.put("liveList", liveList);
			session.put("pageindex", pageindex);
			session.put("pageCount", pageCount);
			return "live";
		} else {
			return INPUT;
		}
	}

	// 模糊数据
	public String mohu() {
		int pageindexLike = 1;
		if (this.pageIndexLike != 0) {
			pageindexLike = pageIndexLike;
		}
		if (parma == null) {
			if (session.get("parma") != null) {
				parma = (String) session.get("parma");
			}
		}
		int countLike = this.liveBiz.findCountByLike(parma);
		System.out.println(countLike + "///////");
		int pageSize = 1;
		if (parma == null || parma.equals("")) {
			pageSize = 5;
		} else {
			pageSize = 1;
		}
		int pageCountLike = (countLike % pageSize == 0) ? (countLike / pageSize)
				: (countLike / pageSize + 1);
		// System.out.println(pageCountLike+"?????");
		if (pageindexLike < 1) {
			pageindexLike = 1;
		} else if (pageindexLike > pageCountLike) {
			pageindexLike = pageCountLike;
		}
		List<Liverecord> list = this.liveBiz.findLivesByifendIdLike(parma,
				pageindexLike, pageSize);
		if (list != null) {
			int flag = 1;
			session.put("flag", flag);
			session.put("parma", parma);
			session.put("listLike", list);
			session.put("pageindexLike", pageindexLike);
			session.put("pageCountLike", pageCountLike);
			return "live";
		} else {
			return "input";
		}
	}

	// 假删除
	public String delete() {
		Liverecord live = this.liveBiz.findLive(id);
		int roomId = live.getRoomId();
		this.roomBiz.updateifendIdById(roomId);
		this.liveBiz.deleteLive(id);
		fenyes();
		return "live";
	}

	// 查询订单所有数据
	public String getLiveRoom() {
		if (id != 0) {
			Liverecord live = this.liveBiz.findLive(id);
			Room rooms = this.roomBiz.findRoomById(live.getRoomId());
			session.put("live", live);
			session.put("room", rooms);
		}
		return "liveroom";
	}

	// 查询订单所有数据以便做相应的修改
	public String getLiveRoom_2() {
		if (id != 0) {
			Liverecord live = this.liveBiz.findLive(id);
			Room rooms = this.roomBiz.findRoomById(live.getRoomId());
			session.put("live", live);
			session.put("room", rooms);
		}
		return "liveroom_2";
	}
}
