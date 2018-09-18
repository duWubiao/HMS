package cn.hms.entity;

import java.util.Date;

public class User {
    private Integer id;//用户id
    private String username;//用户名
    private String password;//密码
//    private Integer sex;//用户性别1、男2、女
//    private Integer age;//用户年龄
    private String name;//姓名
    private String idCard;//身份证号
    private Integer userId;//用户角色
    private Date regtime;//注册时间
    private String phone;//电话号码
    private Integer rid;//用户角色
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
