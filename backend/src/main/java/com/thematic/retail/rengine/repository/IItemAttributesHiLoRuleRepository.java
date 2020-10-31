package com.thematic.retail.rengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thematic.retail.rengine.entity.ItemAttributesHiLoRule;

@Repository
public interface IItemAttributesHiLoRuleRepository extends CrudRepository<ItemAttributesHiLoRule, Long> {
	
	//public Course findByCourseName(String courseName);

}
