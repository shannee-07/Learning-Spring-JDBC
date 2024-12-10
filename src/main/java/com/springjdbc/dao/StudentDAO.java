package com.springjdbc.dao;

import com.springjdbc.entities.Student;

public interface StudentDAO {
	public int insert(Student student);
	public int update(Student student);
	public int delete(int id);
}
