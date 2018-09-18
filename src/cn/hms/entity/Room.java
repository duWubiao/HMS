package cn.hms.entity;

public class Room {
	private Integer id;// 房间id号
	private String number;// 相应房间号
	private Integer type;// 房间类型1、2、3
	private String typename;// 房间类型名字
	private Integer ifendId;// 标记该房间是否有人入住
	private Roomtype roomType;
	//private Liverecord live;

//	public Liverecord getLive() {
//		return live;
//	}
//
//	public void setLive(Liverecord live) {
//		this.live = live;
//	}


	public Integer getId() {
		return id;
	}

	public Roomtype getRoomType() {
		return roomType;
	}

	public void setRoomType(Roomtype roomType) {
		this.roomType = roomType;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getIfendId() {
		return ifendId;
	}

	public void setIfendId(Integer ifendId) {
		this.ifendId = ifendId;
	}

}
