package com.lu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.lu.domain.User;
import com.lu.utils.JDBCUtils;
/**
 * UserDao
 * @author Luge
 *
 */
public class UserDao {
	@Test
	public  void test() {
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet result=null;
		try {
			conn = JDBCUtils.getConnection();
			String sql="select * from user";
			pre = conn.prepareStatement(sql);
			result = pre.executeQuery();
			User user=new User();
			while(result.next()) {
				user.setAge(result.getDouble("age"));
				user.setName(result.getString("name"));
				user.setBirthday(result.getDate("birthday"));
				user.setMess(result.getString("mess"));
			}
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, pre, result);
		}
	}
	@Test
	public void test02() {
		Connection conn =null;
		PreparedStatement pre=null;
		ResultSet result=null;
		try {
			conn = JDBCUtils.getDruidConnection();
			String sql="select * from user";
			pre = conn.prepareStatement(sql);
			result = pre.executeQuery();
			User user=new User();
			while(result.next()) {
				user.setAge(result.getDouble("age"));
				user.setName(result.getString("name"));
				user.setBirthday(result.getDate("birthday"));
				user.setMess(result.getString("mess"));
			}
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(conn, pre, result);
		}
	}
}
