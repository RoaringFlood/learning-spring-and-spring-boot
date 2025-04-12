package com.yalciny.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yalciny.learn_jpa_and_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY =
			"""
				insert into course
				values (?, ?, ?);
			""";
	private static String DELETE_QUERY =
			"""
				delete course where id = ?;
			""";
	private static String SELECT_QUERY =
			"""
				select * from course where id = ?;
			""";
	
	public void insert(Course course) {
		
		springJdbcTemplate.update(INSERT_QUERY, 
				course.getId(), course.getName(), course.getAuthor());
	}
	public void delete(int deleteId) {
		
		springJdbcTemplate.update(DELETE_QUERY, deleteId);
	}
	public Course find(int findId) {
		
		return springJdbcTemplate.queryForObject(SELECT_QUERY, 
												new BeanPropertyRowMapper<>(Course.class), findId);
	}
}
