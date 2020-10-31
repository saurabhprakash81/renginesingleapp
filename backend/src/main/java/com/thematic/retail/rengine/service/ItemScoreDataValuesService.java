package com.thematic.retail.rengine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thematic.retail.rengine.entity.ItemAttributesHiLoRule;
import com.thematic.retail.rengine.entity.ItemScoreDataValues;
import com.thematic.retail.rengine.model.ItemScore;
import com.thematic.retail.rengine.repository.IItemScoreDataValuesRepository;

@Service
public class ItemScoreDataValuesService {

	@Autowired
	private IItemScoreDataValuesRepository itemScoreDataValuesRepo;

	public List<ItemScoreDataValues> getAllItemScoreDataValues() {
		List<ItemScoreDataValues> itemScoreDataValuesList = new ArrayList<ItemScoreDataValues>();
		Iterable<ItemScoreDataValues> itemScoreDataValuesFromDB = itemScoreDataValuesRepo.findAll();
		for (ItemScoreDataValues itemScoreDataValues : itemScoreDataValuesFromDB) {
			itemScoreDataValuesList.add(itemScoreDataValues);
		}
		return itemScoreDataValuesList;
	}

	public void addItemScoreDataValues(List<ItemScoreDataValues> itemScoreDataValuesList) {
		for (ItemScoreDataValues itemScoreDataValues : itemScoreDataValuesList) {
			addItemScoreDataValues(itemScoreDataValues);
		}
	}

	public void addItemScoreDataValues(ItemScoreDataValues itemScoreDataValues) {
		itemScoreDataValuesRepo.save(itemScoreDataValues);
	}

	public ItemScoreDataValues deleteItemScoreDataValues(ItemScoreDataValues itemScoreDataValues) {
		itemScoreDataValuesRepo.delete(itemScoreDataValues);
		return itemScoreDataValues;
	}

	public ItemAttributesHiLoRule deleteItemScoreDataValues(int ID) {
		itemScoreDataValuesRepo.deleteById(ID);
		return null;
	}

	public List<ItemScore> getItemScoreList() {
		List<ItemScore> itemScoreList = new ArrayList<ItemScore>();

		List<ItemScoreDataValues> itemScoreDataValuesList = getAllItemScoreDataValues(); 
		ItemScore itemScore;
		
		for (ItemScoreDataValues itemScoreDataValues : itemScoreDataValuesList) {
			itemScore = new ItemScore(itemScoreDataValues.getId(),itemScoreDataValues.getItemKey(), itemScoreDataValues.getItemName(),
					itemScoreDataValues.getDepartment(), itemScoreDataValues.getCategory(), itemScoreDataValues.getSubCategory(),
					itemScoreDataValues.getItemClass(), itemScoreDataValues.getPrice(), itemScoreDataValues.getAbandonmentRate(), itemScoreDataValues.getScore(),
					itemScoreDataValues.getAdjustedScore(), itemScoreDataValues.getRecommended(), itemScoreDataValues.isOverride());
			itemScoreList.add(itemScore);
		}		
		return itemScoreList;
	}
	
	public List<ItemScore> updateItemScoreDataValues(List<ItemScore> itemScoreList) {
		ItemScoreDataValues itemScoreDataValues;
		for (ItemScore itemScore : itemScoreList) {
			itemScoreDataValues = new ItemScoreDataValues(itemScore.getItemKey(), itemScore.getItemName(), itemScore.getDepartment(), 
					itemScore.getCategory(), itemScore.getSubCategory(), itemScore.getItemClass(), itemScore.getCost(), itemScore.getAbandonmentRate(), 
					itemScore.getScore(), itemScore.getAdjustedScore(), itemScore.getRecommended(), itemScore.isOverride());
			itemScoreDataValues.setId(itemScore.getId());			
			addItemScoreDataValues(itemScoreDataValues);
		}
		return itemScoreList;
	}
}
