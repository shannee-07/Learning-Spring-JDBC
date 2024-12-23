package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springjdbc.dao.StudentDAO;
import com.springjdbc.entities.Student;

public class App {
	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/springjdbc/config.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDAO studentDao = context.getBean("studentDao", StudentDAO.class);
//		Student student = new Student(13, "Mukesh Ambani","Mumbai");
//		int result = studentDao.insert(student);
//		int result = studentDao.update(student);
//		int result = studentDao.delete(2);
//		System.out.println("Rows affected: "+result);
		List<Student> students = studentDao.getAllStudents();
		for (Student student : students) {
			System.out.println(student);
		}
	}

}
