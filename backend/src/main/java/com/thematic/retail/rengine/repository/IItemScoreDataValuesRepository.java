package com.thematic.retail.rengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thematic.retail.rengine.entity.ItemScoreDataValues;

@Repository
public interface IItemScoreDataValuesRepository extends CrudRepository<ItemScoreDataValues, Integer> {

}
