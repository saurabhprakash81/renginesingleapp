package com.thematic.retail.rengine.model;

import java.util.List;

public class Category {
	
	private int categoryId;
		
	private String categoryName;
	
	private boolean selected;
	
	private boolean disabled;
	
	private List<SubCategories> subCategoriesList;

	public Category(int categoryId, String categoryName, boolean selected, List<SubCategories> subCategoriesList) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.selected = selected;
		this.subCategoriesList = subCategoriesList;
	}

	
	public Category() {
	}


	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public List<SubCategories> getSubCategoriesList() {
		return subCategoriesList;
	}

	public void setSubCategoriesList(List<SubCategories> subCategoriesList) {
    if(this.selected) {
      subCategoriesList.forEach(
        sub -> {sub.setSelected(true);
                sub.setDisabled(true);
      }); 
    }
	  
		this.subCategoriesList = subCategoriesList;
	}
	
	public boolean isDisabled() {
    return disabled;
  }


  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }
	

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", selected=" + selected
				+ ", subCategoriesList=" + subCategoriesList + "]";
	}

}
