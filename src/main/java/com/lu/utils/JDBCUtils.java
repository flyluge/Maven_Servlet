package com.lu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
  *  数据库连接工具类
 * @author Luge
 *
 */
public class JDBCUtils {
	/**
	  *  普通方式获取链接
	 * @return Connection对象
	 */
	public static Connection getConnection() {
		try {
			//加载配置文件
			Properties p=new Properties();
			p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			//配置相关内容
			Class.forName(p.getProperty("driverClassName"));
			String name=p.getProperty("username");
			String password=p.getProperty("password");
			String url=p.getProperty("url");
			//获取Connection连接
			return DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	  *  关闭连接
	 * @param connection Connection对象
	 * @param preparedStatement PreparedStatement对象
	 * @param resultSet ResultSet对象
	 */
	public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) {
		try {
			if(resultSet!=null) {
				resultSet.close();
			}
			if(preparedStatement!=null) {
				preparedStatement.close();
			}
			if(connection!=null) {
				connection.close();
			}
			resultSet=null;
			preparedStatement=null;
			connection=null;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	  *  从Druid数据库连接池中获取Connection对象
	 * @return Connection对象
	 */
	public static Connection getDruidConnection() {
		try {
			//创建并配置数据源
			Properties p=new Properties();
			p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			/*
			 *  //手写方式
			 * DruidDataSource dds=new DruidDataSource(); dds.setUrl(p.getProperty("url"));
			 * dds.setUsername(p.getProperty("username"));
			 * dds.setPassword(p.getProperty("password"));
			 * dds.setDriverClassName(p.getProperty("driverClassName"));
			 */
			//调用配置文件方式
			DruidDataSource dds=(DruidDataSource) DruidDataSourceFactory.createDataSource(p);
			dds.setInitialSize(5);//初始化池子大小
			return dds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
