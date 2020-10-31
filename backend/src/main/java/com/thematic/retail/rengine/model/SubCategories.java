package com.thematic.retail.rengine.model;

import java.util.List;

public class SubCategories {
	
	private int subCategoryId;
	
	private String subCategoryName;
	
	private boolean selected;
	
	private boolean disabled;
	
	private List<ItemClass> itemClassList;

	public SubCategories(int subCategoryId, String subCategoryName, boolean selected, List<ItemClass> itemClassList) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.selected = selected;
		this.itemClassList = itemClassList;
	}
	
	public SubCategories() {
	}
	
	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<ItemClass> getItemClassList() {
		return itemClassList;
	}

	public void setItemClassList(List<ItemClass> itemClassList) {
    if(this.selected) {
      itemClassList.forEach(
        item -> {item.setSelected(true);
                item.setDisabled(true);
      }); 
    }

	  
		this.itemClassList = itemClassList;
	}

	 public boolean isDisabled() {
	    return disabled;
	  }


	  public void setDisabled(boolean disabled) {
	    this.disabled = disabled;
	  }

	

	@Override
	public String toString() {
		return "SubCategories [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", selected="
				+ selected + ", itemClassList=" + itemClassList + "]";
	}

}
