package com.thematic.retail.rengine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thematic.retail.rengine.entity.ItemAttributes;
import com.thematic.retail.rengine.repository.IItemAttributesRepository;

@Service
public class ItemAttributeService {
	
	@Autowired
	private IItemAttributesRepository itemAttrRepo;
	
	public List<ItemAttributes> getAllItemAttributes(){
		List<ItemAttributes> itemAttributeList = new ArrayList<ItemAttributes>();
		Iterable<ItemAttributes> itemAttrListFromDB = itemAttrRepo.findAll();
		for (ItemAttributes ItemAttribute : itemAttrListFromDB) {
			itemAttributeList.add(ItemAttribute);
		}
		return itemAttributeList;
	}
	
	public void addItemAttribute(List<ItemAttributes> itemAttributeList){
		for (ItemAttributes itemAttribute : itemAttributeList) {
			addItemAttributes(itemAttribute);
		}
		
	}
	
	public void addItemAttributes(ItemAttributes itemAttributes) {
		itemAttrRepo.save(itemAttributes);
	}
	
	public ItemAttributes  deleteItemAttributes(ItemAttributes itemAttributes) {
		itemAttrRepo.delete(itemAttributes);
		return itemAttributes;
	}
	
	public ItemAttributes deleteItemAttributes(long ID) {
		itemAttrRepo.deleteById(ID);
		return null;
	}


}
