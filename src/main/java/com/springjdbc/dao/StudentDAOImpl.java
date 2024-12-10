package com.springjdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.entities.Student;

public class StudentDAOImpl implements StudentDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query = "INSERT INTO student (id, name, city) VALUES (?, ?, ?)";	
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
