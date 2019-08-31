package com.lu.dao.impl;

import org.junit.Test;

import com.lu.dao.AdminDao;
import com.lu.domain.Admin;

public class AdminDaoimpl extends BaseDaoimpl<Admin> implements AdminDao{
	@Test
	public void tese() {
		System.out.println(findById(1));
	}
}
