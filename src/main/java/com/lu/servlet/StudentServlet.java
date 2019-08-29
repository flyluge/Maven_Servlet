package com.lu.servlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lu.domain.Student;
import com.lu.utils.MyBeanUtils;
/**
  *  用户Servlet
 * @author Luge
 *
 */
public class StudentServlet extends BaseServlet{

	private static final long serialVersionUID = 1L;
	/**
	  *  用户登陆 验证账号与密码
	 * @param req
	 * @param resp
	 */
	public void login(HttpServletRequest req,HttpServletResponse resp) {
	
	}
	/**
	 * 用户注册
	 * @param req
	 * @param resp
	 * @throws UnsupportedEncodingException 
	 */
	public void regist(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		//封装学生数据
		Student s = MyBeanUtils.populate(Student.class, req.getParameterMap());
		//验证不为空
		System.out.println(MyBeanUtils.isNUll(s.getBirthday(),s.getMess(),s.getPassword()));
		System.out.println(s);
	}
}
