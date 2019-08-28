package com.lu.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/**
 * Servlet数据封装类
 * @author Luge
 *
 */
public class MyBeanUtils2 {
	//日期转换模式 默认格式:年-月-日
	public static String datepattern="yyyy-MM-dd";
	public static <T> T populate(Class<T> clazz,Map<String,String[]> map) {
		//获取所有的属性
		Field[] fields = clazz.getDeclaredFields();
		T obj=null;
		try {
			obj = clazz.newInstance();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//遍历属性
		for (Field field : fields) {
			//获取属性名
			String name=field.getName();
			//获取属性的值
			String[] s = map.get(name);
			if(s==null) {
				s=new String[1];
				s[0]="";
			}
			//获取属性的方法名
			String methodname="set"+name.substring(0,1).toUpperCase()+name.substring(1,name.length());
			if(s!=null) {
				try {
					String o=s[0];
					Method method = clazz.getMethod(methodname, field.getType());
					switch(field.getType().toString()) {
						case "class java.lang.String":method.invoke(obj, o);break;
						case "class java.lang.Integer":method.invoke(obj, Integer.parseInt(o));break;
						case "int":method.invoke(obj, Integer.parseInt(o));break;
						case "class java.lang.Double":method.invoke(obj, Double.parseDouble(o));break;
						case "double":method.invoke(obj, Double.parseDouble(o));break;
						case "class java.lang.Float":method.invoke(obj, Float.parseFloat(o));break;
						case "float":method.invoke(obj, Float.parseFloat(o));break;
						case "class java.lang.Boolean":method.invoke(obj, Boolean.parseBoolean(o));break;
						case "boolean":method.invoke(obj, Boolean.parseBoolean(o));break;
						case "class java.util.Date":method.invoke(obj, convertDate(datepattern, o));break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return obj;
	}
	/**
	  *   将字符串日期转换为Date
	 * @param datepattern 转换格式
	 * @param date 日期字符串
	 * @return Date对象
	 */
	public static Date convertDate(String datepattern,String date) {
		if(date.trim().equals("")) {
			return null;
		}
		SimpleDateFormat sdf=new SimpleDateFormat(datepattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
