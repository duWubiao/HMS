package cn.hms.entity;

import java.util.Date;

public class Liverecord {
	private Integer id;// ס����ӛid
	private Integer roomId;// ���gid̖
	private Integer rid;// ��Աid��
	private String name;// ס������
	private Integer day;// ��ס����
	private String idCard;// ���֤��
	private Integer price;// �۸�
	private Date regtime;// ��סʱ��
	private String phone; // �绰����
	private Integer ifendId;// ����Ƿ���ס
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
