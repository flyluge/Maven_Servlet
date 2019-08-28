package com.lu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

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
	public void add() {
		Connection conn=null;
		PreparedStatement pre=null;
		User user=new User("张三",15,"学生",new java.util.Date());
		try {
			conn=JDBCUtils.getDruidConnection();
			String sql="insert into user(name,age,mess,birthday) values(?,?,?,?)";
			pre=conn.prepareStatement(sql);
			pre.setString(1, user.getName());
			pre.setDouble(2, user.getAge());
			pre.setString(3, user.getMess());
			pre.setDate(4, new Date(user.getBirthday().getTime()));
			int flag = pre.executeUpdate();
			if(flag>0) {
				System.out.println("插入成功");
			}
		}catch(Exception e) {
			e.printStackTrace();
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
