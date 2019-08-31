package com.lu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.lu.dao.StudentDao;
import com.lu.domain.Student;
import com.lu.utils.JDBCUtils;

public class StudentDaoimpl extends BaseDaoimpl<Student> implements StudentDao{
	@Test
	public void test01() { 
		try {
			JDBCUtils.startTransaction();
			List<Student> list = findByPageAndSql("select * from student where stuname like ?",2,5,"%路%");
			for (Student student : list) {
				System.out.println(student);
			}
			JDBCUtils.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test02() {
		try {
			JDBCUtils.startTransaction();
			Student s = findOneBySql("select * from student where stuid=?","2016211809");
			s.setId(31);
			delete(s);
			System.out.println(s);
			System.out.println(findAllCount());
			JDBCUtils.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 查询所有
	 * @return List Student集合
	 */
	public List<Student> findAll() {
		String sql="select * from student";
		List<Student> list=new ArrayList<Student>();
		try {
			list = new QueryRunner(JDBCUtils.getDataSource()).query(sql,new BeanListHandler<Student>(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 通过stuid和密码查询
	 * @param stuid
	 * @param pass
	 * @return
	 */
	public Student findByStuIdAndPass(String stuid,String pass) {
		String sql="select * from student where stuid=? and password=?";
		try {
			Student s=new QueryRunner(JDBCUtils.getDataSource()).query(sql,new BeanHandler<Student>(Student.class),stuid,pass);
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Student> findByStuId(String stuid) {
		String sql="select * from student where stuid=?";
		List<Student> list=new ArrayList<Student>();
		try {
			list = new QueryRunner(JDBCUtils.getDataSource()).query(sql,new BeanListHandler<Student>(Student.class),stuid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Student> findByPageAndSql(String sql, Integer currPage, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
}
