package com.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDAO;
import com.springjdbc.dao.StudentDAOImpl;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.dao"})
public class JdbcConfig {
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/learning");
		dataSource.setUsername("root");
		dataSource.setPassword("D@tabase123");
		return dataSource;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(getDataSource());
	}
}
