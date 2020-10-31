package com.thematic.retail.rengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thematic.retail.rengine.model.Course;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Long> {
	
	public Course findByCourseName(String courseName);

}
