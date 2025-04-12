package com.yalciny.learn_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Course") //table adı ile eşleşiyorsa yazmasakta olur (jpa)
public class Course {
	
	@Id
	private long id;
	@Column(name = "name") // column lar eşleştiği için yazmasakta olur (jpa)
	private String name;
	@Column(name = "author") // column lar eşleştiği için yazmasakta olur (jpa)
	private String author;
	
	
	public Course() {
		
	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
}
