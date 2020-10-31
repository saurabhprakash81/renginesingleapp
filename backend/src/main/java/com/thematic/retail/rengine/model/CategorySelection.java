package com.thematic.retail.rengine.model;

import java.util.List;

public class CategorySelection {
	
	private List<Integer> categoryIds;
	
	private List<Integer> subCategoryIds;
	
	private List<Integer> itemClassIds;

	public CategorySelection(List<Integer> categoryIds, List<Integer> subCategoryIds, List<Integer> itemClassIds) {
		super();
		this.categoryIds = categoryIds;
		this.subCategoryIds = subCategoryIds;
		this.itemClassIds = itemClassIds;
	}

	public CategorySelection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getSubCategoryIds() {
		return subCategoryIds;
	}

	public void setSubCategoryIds(List<Integer> subCategoryIds) {
		this.subCategoryIds = subCategoryIds;
	}

	public List<Integer> getItemClassIds() {
		return itemClassIds;
	}

	public void setItemClassIds(List<Integer> itemClassIds) {
		this.itemClassIds = itemClassIds;
	}

	@Override
	public String toString() {
		return "CategorySelection [categoryIds=" + categoryIds + ", subCategoryIds=" + subCategoryIds
				+ ", itemClassIds=" + itemClassIds + "]";
	}
	
}
