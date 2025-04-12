package com.yalciny.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yalciny.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.yalciny.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import com.yalciny.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
	private Course course = new Course(1,"Spring","Yalcin");
	
	/*Spring Data Jpa*/
	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	/* JPA SECTION 
	@Autowired
	private CourseJpaRepository repository;
	*/
	
	/* JDBC SECTION
	@Autowired
	private CourseJdbcRepository repository;
	*/
	
	
	@Override
	public void run(String... args) throws Exception {
		/*SpringDataJdbc*/
		repository.save(course);
		repository.save(new Course(2,"C#","Yalcin"));
		repository.save(new Course(3,"Java","Yalcin"));
		repository.deleteById(2l); //long tipinde aldığı için 2l diyoruz
		System.out.println(repository.findById(1l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("Yalcin"));
		
		/* Jpa vs Jdbc de kendi metodlarımızı kullanıyorduk ama SpringDataJdbc de hazır metodları çağırıyoruz
		repository.insert(course);
		repository.insert(new Course(2,"C#","Yalcin"));
		repository.insert(new Course(3,"Java","Yalcin"));
		
		repository.delete(2);
		
		System.out.println(repository.find(1));
		*/
	}
	
}
