package com.lu.domain ;
public class Admin {
	private Integer id;
	private String adminid;
	private String adminname;
	private String adminpassword;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	
	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	
	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminid=" + adminid + ", adminname=" + adminname + ", adminpassword="
				+ adminpassword + "]";
	}
	
}
