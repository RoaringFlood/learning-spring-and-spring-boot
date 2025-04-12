package com.yalciny.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.yalciny.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public void delete(int deleteId) {
		Course course = entityManager.find(Course.class, deleteId);
		entityManager.remove(course);
	}
	
	public Course find(int findId) {
		return entityManager.find(Course.class, findId);
	}
}
