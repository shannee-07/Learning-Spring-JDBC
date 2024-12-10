package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Student;

@Component("studentDao")
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query = "INSERT INTO student (id, name, city) VALUES (?, ?, ?)";
		int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public StudentDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int update(Student student) {
		String query = "UPDATE student SET name = ?, city = ? WHERE id = ?";
		int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	@Override
	public int delete(int id) {
		String query = "DELETE FROM student WHERE id = ?";
		int r = this.jdbcTemplate.update(query, id);
		return r;
	}

	@Override
	public Student getStudent(int id) {
		String query = "SELECT * FROM student WHERE id = ?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		return this.jdbcTemplate.queryForObject(query, rowMapper, id);
	}

	@Override
	public List<Student> getAllStudents() {
		return this.jdbcTemplate.query("SELECT * FROM student", new RowMapperImpl());
	}

}
