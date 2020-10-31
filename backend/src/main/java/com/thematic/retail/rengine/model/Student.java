package com.thematic.retail.rengine.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import javax.persistence.Id;



@Entity
@Table(name = "STUDENT")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private long studentID;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "STUDENT_COURSE" , joinColumns = { @JoinColumn(name = "STUDENT_ID") },  inverseJoinColumns= { @JoinColumn(name = "COURSE_ID")})
	private Set<Course> courses;

	public Student() {
	}	

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Student(String studentName, Set<Course> courses) {
		super();
		this.studentName = studentName;
		this.courses = courses;
	}

	public long getStudentID() {
		return studentID;
	}

	public void setStudentID(long studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", courses=" + courses + "]";
	}
	
	
	
	
	

}
