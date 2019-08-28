package com.lu.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lu.domain.User;
import com.lu.utils.MyBeanUtils;

/**
 * Servlet测试类
 * 
 * @author Luge
 */
public class TestServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	public void Tes01(HttpServletRequest req, HttpServletResponse resp) {
		List<String> list = new ArrayList<String>();
		list.add("盖伦");
		list.add("亚索");
		list.add("蛮王");
		list.add("皇子");
		HttpSession session = req.getSession();
		session.setAttribute("list", list);
		this.write(true, list, resp);
	}

	public String Tes02(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("Test02被调用了");
		String authType = req.getAuthType();
		System.out.println(authType);
		return null;
	}

	public String test03(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String mess = req.getParameter("mess");
		User user = new User(name, (double) age, mess, null);
		req.setAttribute("user", user);
		return "Test02.jsp";
	}

	public String test04(HttpServletRequest req, HttpServletResponse resp) {
		User user = MyBeanUtils.populate(User.class, req.getParameterMap());
		System.out.println(user);
		req.setAttribute("user", user);
		return "Test02.jsp";
	}
}
