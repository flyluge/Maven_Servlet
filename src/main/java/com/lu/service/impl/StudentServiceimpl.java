package com.lu.service.impl;

import java.util.List;

import com.lu.dao.StudentDao;
import com.lu.dao.impl.StudentDaoimpl;
import com.lu.domain.Student;
import com.lu.service.StudentService;
/**
 * 学生service类
 * @author Luge
 *
 */
public class StudentServiceimpl implements StudentService{
	private StudentDao studentDao=new StudentDaoimpl();
	/**
	 * 学生登陆
	 */
	@Override
	public Student login(String stuid, String password) {
		return studentDao.findByStuIdAndPass(stuid, password);
	}
	/**
	 * 学生注册
	 */
	@Override
	public boolean regist(Student s) {
		//验证stuid是否重复
		List<Student> list=studentDao.findByStuId(s.getStuid());
		if(list.size()>0) {
			return false;
		}else {
			studentDao.add(s);
			return true;
		}
	}
}
