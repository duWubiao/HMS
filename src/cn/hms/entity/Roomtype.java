package cn.hms.entity;

public class Roomtype {
	 private Integer id;//�������ͼ۸�id
	 private Integer type;//��������
	// private Integer hourPrice;//ÿСʱ�۸�
	 private Integer dayPrice;//ÿ��۸�
	
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
