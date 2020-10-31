package com.thematic.retail.rengine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thematic.retail.rengine.entity.ItemAttributes;
import com.thematic.retail.rengine.entity.ItemAttributesHiLoRule;
import com.thematic.retail.rengine.model.Student;
import com.thematic.retail.rengine.repository.IItemAttributesHiLoRuleRepository;
import com.thematic.retail.rengine.repository.IItemAttributesRepository;

@Service
public class ItemAttributeHiLoRuleService {

	@Autowired
	private IItemAttributesHiLoRuleRepository itemAttrHiLoRepo;

	public List<ItemAttributesHiLoRule> getAllItemAttributeHiLoRule() {
		List<ItemAttributesHiLoRule> itemAttributeHiLoList = new ArrayList<ItemAttributesHiLoRule>();
		Iterable<ItemAttributesHiLoRule> itemAttributeHiLoFromDB = itemAttrHiLoRepo.findAll();
		for (ItemAttributesHiLoRule itemAttributeHiLo : itemAttributeHiLoFromDB) {
			itemAttributeHiLoList.add(itemAttributeHiLo);
		}
		return itemAttributeHiLoList;
	}

	public void addItemAttributeHiLoRule(List<ItemAttributesHiLoRule> itemAttributeHiLoList) {
		for (ItemAttributesHiLoRule itemAttributeHiLo : itemAttributeHiLoList) {
			addItemAttributeHiLoRule(itemAttributeHiLo);
		}

	}

	public void addItemAttributeHiLoRule(ItemAttributesHiLoRule itemAttributesHiLoRule) {
		itemAttrHiLoRepo.save(itemAttributesHiLoRule);
	}

	public ItemAttributesHiLoRule deleteItemAttributesHiLoRule(ItemAttributesHiLoRule itemAttributesHiLoRule) {
		itemAttrHiLoRepo.delete(itemAttributesHiLoRule);
		return itemAttributesHiLoRule;
	}

	public ItemAttributesHiLoRule deleteItemAttributesHiLoRule(long ID) {
		itemAttrHiLoRepo.deleteById(ID);
		return null;
	}

}
