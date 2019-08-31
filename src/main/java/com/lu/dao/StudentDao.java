package com.lu.dao;

import java.util.List;

import com.lu.domain.Student;

public interface StudentDao extends BaseDao<Student>{

	Student findByStuIdAndPass(String stuid, String password);

	List<Student> findByStuId(String stuid);

}
