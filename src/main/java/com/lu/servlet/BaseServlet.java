package com.lu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
/**
 * BaseServlet为servlet层的父类 重写了HttpServlet类的service方法
  *   在进行servlet请求时,需要指明调用的方法
  *   格式:地址+?+method=调用的方法名+&+其他数据
 * @author Luge
 */
public class BaseServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	/**
	  *  解析请求 ,获取要调用的method方法,并调用
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//获取method
			String method=req.getParameter("method");
			Class<? extends BaseServlet> clazz = this.getClass();
			//若method不存在 调用将method赋值为默认方法
			if(method==null||method.trim().equals("")) {
				method="defaultMethod";
			}
			//调用方法
			Method m1=null;
			try {
				m1 = clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			} catch (NoSuchMethodException e) {
				method="defaultMethod";
				m1 = clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			}
			//执行方法并获取url
			String url=(String) m1.invoke(clazz.newInstance(),req, resp);
			if(url!=null) {
				req.getRequestDispatcher(url).forward(req, resp);
			}else {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	  *  当method为空时调用的默认的方法
	 * @param req HttpServletRequest
	 * @param resp HttpServletResponse
	 * @return null
	 */
	public String defaultMethod(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			resp.getWriter().write("欢迎调用defaultMethod方法");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	  *   将对象转成json输出
	 * @param success 成功或是失败
	 * @param data 需要转json的数据
	 * @param resp HttpServletResponse
	 */
	public void write(boolean success,Object data,HttpServletResponse resp) {
		Map<Object,Object> map=new HashMap<Object,Object>();
		map.put("message", success);
		map.put("data", data);
		String jsonString = JSON.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect);
		resp.setContentType("text/html;charset=utf-8");
		try {
			resp.getWriter().write(jsonString);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
