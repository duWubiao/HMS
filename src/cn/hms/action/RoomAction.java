package cn.hms.action;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;

import cn.hms.entity.Room;
import cn.hms.entity.Roomtype;
import cn.hms.service.RoomBiz;
import cn.hms.service.UserBiz;
import cn.hms.tools.PageSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoomAction extends ActionSupport {

	private RoomBiz roomBiz;
	private Room room;
	private String flag;
	private int pageIndex;
	private PageSupport pageSupport;

	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}

	private List<String> list = new ArrayList<String>();

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setRoomBiz(RoomBiz roomBiz) {
		this.roomBiz = roomBiz;
	}

	public String number() {
		if (room.getType() == 0) {
			flag = "false";
			result = "<font color='red'>«Î—°‘Ò∑øº‰!</font>";
		} else {
			flag = "true";
			// ActionContext ac = ActionContext.getContext();
			// Map<String, Object> session = ac.getSession();
			List<Room> roomList = roomBiz.findNumberByType(room.getType());
			for (Room room : roomList) {
				list.add(room.getNumber());
			}
			System.out.println(list + ">>>>>>>>");
		}
		return SUCCESS;
	}

	public String fenye() {
		int pageindex = 1;
		if (this.pageIndex != 0) {
			pageindex = pageIndex;
		}
		int count = this.roomBiz.findRoomCount();
		int pageSize = 10;
		int pageCount = (count % pageSize == 0) ? (count / pageSize) : (count
				/ pageSize + 1);
		if (pageindex < 1) {
			pageindex = 1;
		} else if (pageindex > pageCount) {
			pageindex = pageCount;
		}
		List<Object[]> listObject = this.roomBiz.findRoomByidfendId(pageindex,
				pageSize);
		List<Room> roomList = new ArrayList<Room>();
		List<Roomtype> typeList = new ArrayList<Roomtype>();
		for (Object[] obj : listObject) {
			Room room = new Room();
			room.setId(((Room) obj[0]).getId());
			room.setNumber(((Room) obj[0]).getNumber());
			room.setType(((Room) obj[0]).getType());
			room.setTypename(((Room) obj[0]).getTypename());
			room.setIfendId(((Room) obj[0]).getIfendId());
			Roomtype rt = new Roomtype();
			rt.setDayPrice(((Roomtype) obj[1]).getDayPrice());
			roomList.add(room);
			typeList.add(rt);
		}
		for (Roomtype roomtype : typeList) {
			System.out.println(roomtype.getDayPrice() + "//////////");
		}
		// int type = 0;
		// for (Room room : list) {
		// type = room.getType();
		// }
		// System.out.println(type+">>>>>>>>>>>");
		ActionContext ac = ActionContext.getContext();
		Map<String, Object> session = ac.getSession();
		if (list != null) {
			session.put("roomTypeList", typeList);
			session.put("list", roomList);
			session.put("pageindex", pageindex);
			session.put("pageCount", pageCount);
			return "room";
		} else {
			return "input";
		}
	}
}
