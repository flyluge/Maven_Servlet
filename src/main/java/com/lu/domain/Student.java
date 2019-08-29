package com.lu.domain;

import java.util.Date;

public class Student {
	private Integer id;//主码
	private String stuid;//学生id
	private String stuname;//学生姓名
	private String sex;//性别 男/女
	private String mess;//信息
	private String password;//密码
	private Date birthday;
	private Integer testint;
	private Double testdouble;
	private Float testfloat;
	
	public Integer getTestint() {
		return testint;
	}
	public void setTestint(Integer testint) {
		this.testint = testint;
	}
	public Double getTestdouble() {
		return testdouble;
	}
	public void setTestdouble(Double testdouble) {
		this.testdouble = testdouble;
	}
	public Float getTestfloat() {
		return testfloat;
	}
	public void setTestfloat(Float testfloat) {
		this.testfloat = testfloat;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
				+ ", password=" + password + ", birthday=" + birthday + ", testint=" + testint + ", testdouble="
				+ testdouble + ", testfloat=" + testfloat + "]";
	}
	
	
}
