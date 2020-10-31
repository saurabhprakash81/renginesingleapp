package com.thematic.retail.rengine.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thematic.retail.rengine.model.Course;
import com.thematic.retail.rengine.model.Student;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
	
	public List<Student> findByCourses(Course course); 

}
