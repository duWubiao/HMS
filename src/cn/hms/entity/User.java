package cn.hms.entity;

import java.util.Date;

public class User {
    private Integer id;//�û�id
    private String username;//�û���
    private String password;//����
//    private Integer sex;//�û��Ա�1����2��Ů
//    private Integer age;//�û�����
    private String name;//����
    private String idCard;//���֤��
    private Integer userId;//�û���ɫ
    private Date regtime;//ע��ʱ��
    private String phone;//�绰����
    private Integer rid;//�û���ɫ
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public Integer getSex() {
//		return sex;
//	}
//	public void setSex(Integer sex) {
//		this.sex = sex;
//	}
//	public Integer getAge() {
//		return age;
//	}
//	public void setAge(Integer age) {
//		this.age = age;
//	}
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
    

}
