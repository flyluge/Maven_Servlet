package com.lu.service;

import com.lu.domain.Student;

public interface StudentService {

	Student login(String stuid, String password);

	boolean regist(Student s);

}
