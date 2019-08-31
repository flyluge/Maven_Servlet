package com.lu.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Dao层所有接口的父接口 定义了增删改查方法
 * @author Luge
 */
public interface BaseDao<T> {
	/**
	 * 插入一条数据
	 * @param t
	 */
	boolean add(T t);
	/**
	 * 添加一条数据并返回主键
	 * @param t 插入的数据
	 * @return null:插入失败  或者返回插入后的主键
	 * 注意:只对自增长id有效
	 */
	Serializable addBackWithID(T t);
	/**
	  *  根据主码删除一条数据
	 * @param t 带有主码的需要删除的数据
	 * @return true:删除成功
	 * 			false:删除的数据不存在
	 */
	boolean delete(T t);
	/**
	  *  根据主码更新一条数据
	 * @param t 带有主码的需要更新的数据
	 * @return true:更新成功
	 * 			false:更新的数据不存在
	 */
	boolean update(T t);
	/*
	 * 查询所有数量
	 */
	long findAllCount();
	/**
	  * 通过主码查询单条数据
	 * @param id
	 * @return
	 */
	T findById(Serializable id);
	/**
	  *  条件查询单个
	  *  通过sql语句查询单条数据  
	 * @param sql sql语句
	 * @param param 查询参数
	 * @return 查询结果封装bean
	 */
	T findOneBySql(String sql,Object... param);
	/**
	  *  查询所有
	 * @return
	 */
	List<T> findAll();
	/**
	  * 条件查询多个
	  * 通过sql语句条件查询多条数据
	 * @param sql sql语句
	 * @return 查询结果封装List<Bean>
	 */
	List<T> findAllBySql(String sql,Object... param);
	/**
	  * 分页查询
	 * @param currPage 当前页
	 * @param pageSize 页面大小
	 * @return
	 */
	List<T> findByPage(Integer currPage, Integer pageSize);
	/**
	  *  条件分页查询
	  *  通过sql语句与页码条件查询多条数据
	 * @param sql sql语句
	 * @param currPage 当前页
	 * @param pageSize 页面大小
	 * @return
	 */
	List<T> findByPageAndSql(String sql,Integer currPage, Integer pageSize,Object... param);
}
