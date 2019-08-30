package com.lu.servlet;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lu.domain.Student;
import com.lu.service.StudentService;
import com.lu.service.impl.StudentServiceimpl;
import com.lu.utils.FormValidation;
import com.lu.utils.MyBeanUtils;
/**
  *  用户Servlet
 * @author Luge
 *
 */
public class StudentServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
	private StudentService studentService=new StudentServiceimpl();
	/**
	 *  用户登陆 验证账号与密码
	 * @param req
	 * @param resp
	 */
	public void login(HttpServletRequest req,HttpServletResponse resp) {
		Student stu = MyBeanUtils.populate(Student.class, req.getParameterMap());
		System.out.println(stu);
		if(!FormValidation.verifyNUll(stu.getStuid(),stu.getPassword())) {
			this.write(false, "数据填写不全", resp);
			return;
		}
		Student loginstu=studentService.login(stu.getStuid(), stu.getPassword());
		if(loginstu==null) {
			this.write(false, "用户名或密码不正确", resp);
			return;
		}else {
			req.getSession().setAttribute("student", loginstu);
			this.write(true, "登陆成功", resp);
		}
	}
	/**
	 * 用户注册
	 * @param req 
	 * @param resp 
	 * @throws UnsupportedEncodingException 
	 */
	public void regist(HttpServletRequest req,HttpServletResponse resp) throws UnsupportedEncodingException {
		String mess="";
		//校验日期
		if(!FormValidation.isValidDate(req.getParameter("birthday"), "yyyy-MM-dd")) {
			mess+=" 日期格式错误";
			this.write(false, mess, resp);
			return;
		}
		//封装学生数据
		Student s = MyBeanUtils.populate(Student.class, req.getParameterMap());
		System.out.println(s);
		//验证不为空
		if(!FormValidation.isNUll(s.getStuid(),s.getPassword(),s.getStuname(),s.getSex(),s.getBirthday(),s.getMess())) {
			this.write(false, "数据不能存在空值", resp);
			return;
		}else {
			if(!(s.getSex().equals("男")||s.getSex().equals("女"))) {
				mess+=" 性别输入错误";
			}
			if(mess!="") {
				this.write(false, mess, resp);
				return;
			}
			if(!studentService.regist(s)) {
				mess+="注册失败,学号重复";
				this.write(false, mess, resp);
				return;
			}else {
				this.write(true,"注册成功", resp);
			}
		}
	}
}
