package com.yalciny.learn_spring_boot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	
	//courses
	//Course : id, name, author
	@RequestMapping("/courses")
	public List<Course> retrieveAllCourse(){
		return Arrays.asList(
				new Course(1, "C++", "Yalçın"),
				new Course(2, "C#", "Yalçın"),
				new Course(3, "Java", "Yalçın")
				);
	}
}
