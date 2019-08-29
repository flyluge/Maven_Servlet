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
	  *  用户注册
	 * @param req
	 * @param resp
	 * @throws UnsupportedEncodingException 
	 */
	public void regist(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		Student student = MyBeanUtils.populate(Student.class, req.getParameterMap());
		System.out.println(student);
	}
}
