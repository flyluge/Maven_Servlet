package com.lu.domain;

import java.util.Date;

public class User {
	private String name;
	private double age;
	private String mess;
	private Date birthday;
	public User() {
		super();
	}
	
	public User(String name, double age, String mess, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.mess = mess;
		this.birthday = birthday;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	
	public double getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", mess=" + mess + ", birthday=" + birthday + "]";
	}
	
}
