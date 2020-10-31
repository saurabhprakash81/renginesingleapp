package com.thematic.retail.rengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.thematic.retail.rengine.model.Student;
import com.thematic.retail.rengine.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/student",method = RequestMethod.GET)
	public List<Student> getStudents(@RequestParam String id) {
		studentService.initialize();
		List<Student> students = studentService.getStudents();
		return students;
	}
	
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.GET)
	public Student getStudents(@PathVariable("studentId") long studentId) {
		
		return studentService.getStudent(studentId).get();
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		//studentService.initialize();
		Student newStudents = studentService.addStudents(student);
		return newStudents;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.PUT)
	public Student updateStudent(@RequestBody Student student) {
		//studentService.initialize();
		Student updatedstudent = studentService.updateStudents(student);
		return updatedstudent;
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.DELETE)
	public Student deleteStudent(@RequestBody Student student) {
		Student studentDeleted = studentService.deleteStudent(student);
		return studentDeleted;
	}
	
	@RequestMapping(value = "/student/{studentId}", method = RequestMethod.DELETE)
	public Student deleteStudent(@PathVariable("studentId") long studentId) {
		Student studentDeleted = studentService.deleteStudent(studentId);
		return studentDeleted;
	}
	
	//@RequestMapping(value = "/student/course/{courseName}", method = RequestMethod.GET)
	/*public List<Student> getStudents(@PathVariable("courseName") String courseName) {
		//studentService.initialize();
		System.out.println("Input parameter : " + courseName);
		List<Student> students = studentService.getStudentsByCourseName(courseName);
		return students;
	}*/

}
