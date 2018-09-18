package cn.hms.entity;

public class Bank {
	private Integer id;// 酒店消费卡id
	private String name;// 持卡人名字
	private String idCard;// 持卡人身份
	private String bankId;// 卡号
	private Integer rid;// 会员标识，1.会员 2、非会员

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
      
      
}
