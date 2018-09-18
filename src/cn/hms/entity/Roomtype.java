package cn.hms.entity;

public class Roomtype {
	 private Integer id;//房间类型价格id
	 private Integer type;//房间类型
	// private Integer hourPrice;//每小时价格
	 private Integer dayPrice;//每天价格
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
//	public Integer getHourPrice() {
//		return hourPrice;
//	}
//	public void setHourPrice(Integer hourPrice) {
//		this.hourPrice = hourPrice;
//	}
	public Integer getDayPrice() {
		return dayPrice;
	}
	public void setDayPrice(Integer dayPrice) {
		this.dayPrice = dayPrice;
	}
	 
}
