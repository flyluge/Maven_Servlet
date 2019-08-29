package com.lu.domain;

public class Student {
	private int id;//主码
	private String stuid;//学生id
	private String stuname;//学生姓名
	private String sex;//性别 男/女
	private String mess;//信息
	private String password;//密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuid=" + stuid + ", stuname=" + stuname + ", sex=" + sex + ", mess=" + mess
				+ ", password=" + password + "]";
	}
	
}
