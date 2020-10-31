package com.thematic.retail.rengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thematic.retail.rengine.entity.ItemAttributes;

@Repository
public interface IItemAttributesRepository extends CrudRepository<ItemAttributes, Long> {
	
	//public Course findByCourseName(String courseName);

}
