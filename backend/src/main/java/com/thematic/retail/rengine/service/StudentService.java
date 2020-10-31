package com.thematic.retail.rengine.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thematic.retail.rengine.model.Course;
import com.thematic.retail.rengine.model.Student;
import com.thematic.retail.rengine.repository.ICourseRepository;
import com.thematic.retail.rengine.repository.IStudentRepository;

@Service
public class StudentService {

	@Autowired
	private ICourseRepository courseRepository;

	@Autowired
	private IStudentRepository studentRepository;

	public void initialize() {
		// creating dummy data and storing in DB.

		Course course1 = new Course("Java");
		Course course2 = new Course("Scala");
		Course course3 = new Course("Perl");
		Course course4 = new Course("Python");

		courseRepository.save(course1);
		courseRepository.save(course2);
		courseRepository.save(course3);
		courseRepository.save(course4);

		Set<Course> courses1 = new HashSet<Course>();
		courses1.add(course1);
		courses1.add(course2);
		courses1.add(course3);
		courses1.add(course4);

		Set<Course> courses2 = new HashSet<Course>();
		courses2.add(course1);
		courses2.add(course4);

		Student student1 = new Student("1_ROLLNUM", courses1);
		Student student2 = new Student("2_ROLLNUM", courses2);
		Student student3 = new Student("3_ROLLNUM");

		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
	}

	public List<Student> getStudents() {
		List<Student> students = new ArrayList<Student>();
		Iterable<Student> studentListFromDB = studentRepository.findAll();
		for (Student student : studentListFromDB) {
			students.add(student);
		}
		return students;
	}

	public Student deleteStudent(Student student) {
		studentRepository.delete(student);
		return student;
	}

	public Student updateStudents(Student student) {
		studentRepository.save(student);
		return null;
	}

	public Student addStudents(Student student) {
		studentRepository.save(student);
		return null;
	}

	public List<Student> getStudentsByCourseName(String courseName) {
		List<Student> students = new ArrayList<Student>();
		Course course = courseRepository.findByCourseName(courseName);
		Iterable<Student> studentListFromDB = studentRepository.findByCourses(course);
		for (Student student : studentListFromDB) {
			students.add(student);
		}
		return students;
	}

	public Student deleteStudent(long studentId) {
		studentRepository.deleteById(studentId);
		return null;
	}

	public Optional<Student> getStudent(long studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId);
	}

}
