package cn.hms.entity;

import java.util.Date;

public class Liverecord {
	private Integer id;// 住房登記id
	private Integer roomId;// 房間id號
	private Integer rid;// 会员id号
	private String name;// 住户名字
	private Integer day;// 入住天数
	private String idCard;// 身份证号
	private Integer price;// 价格
	private Date regtime;// 入住时间
	private String phone; // 电话号码
	private Integer ifendId;// 标记是否入住
//	private Room roomId;
//
//
//	public Room getRoomId() {
//		return roomId;
//	}
//
//	public void setRoomId(Room roomId) {
//		this.roomId = roomId;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	// public String getRegtime() {
	// return regtime;
	// }
	// public void setRegtime(String regtime) {
	// this.regtime = regtime;
	// }

	public String getPhone() {
		return phone;
	}

	public Date getRegtime() {
		return regtime;
	}

	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIfendId() {
		return ifendId;
	}

	public void setIfendId(Integer ifendId) {
		this.ifendId = ifendId;
	}

}
