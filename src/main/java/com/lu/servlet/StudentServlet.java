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
	public String regist(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		//封装学生数据
		System.out.println("2222");
		Student s = MyBeanUtils.populate(Student.class, req.getParameterMap());
		//验证不为空
		if(!MyBeanUtils.isNUll(s.getStuid(),s.getPassword(),s.getStuname(),s.getSex(),s.getBirthday(),s.getMess())) {
			this.write(false, "数据不能存在空值", resp);
			return null;
		}else {
			return "html/login.html";
		}
	}
}
