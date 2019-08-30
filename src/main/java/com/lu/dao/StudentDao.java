package com.lu.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.lu.domain.Student;
import com.lu.utils.JDBCUtils;

public class StudentDao {
	@Test
	public void test01() {
		Student stu = findById(3);
		System.out.println(stu);
		stu.setBirthday(new Date());
		update(stu);
		stu=findByStuIdAndPass("002", "123456");
		System.out.println(stu);
		List<Student> list = findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	/**
	 * 添加
	 * @param student
	 */
	public void add(Student student) {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql="INSERT INTO `library`.`student`(`stuid`, `stuname`, `sex`, `message`, `password`,`birthday`) VALUES (?,?,?,?,?,?)";
		try {
			queryRunner.update(sql,student.getStuid(), student.getStuname(), student.getSex(), student.getMess(), student.getPassword(),student.getBirthday());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除
	 * @param student
	 */
	public void delete(Student student) {
		String sql="delete from student where id=?";
		try {
			new QueryRunner(JDBCUtils.getDataSource()).update(sql,student.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 修改
	 * @param student
	 */
	public void update(Student student) {
		String sql="UPDATE `library`.`student` SET `stuid` = ?, `stuname` = ?, `sex` = ?, `message` = ?, `password` = ?,`birthday`=? WHERE `id` = ?";
		try {
			new QueryRunner(JDBCUtils.getDataSource()).update(sql,student.getStuid(),student.getStuname(),student.getSex(),student.getMess(), student.getPassword(),student.getBirthday(),student.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过id查询
	 * @param id
	 * @return
	 */
	public Student findById(Serializable id) {
		String sql="select * from student where id=?";
		try {
			Student s=new QueryRunner(JDBCUtils.getDataSource()).query(sql,new BeanHandler<Student>(Student.class),id);
			return s;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
}
