package com.thematic.retail.rengine.model;

import java.util.List;

public class Department {
	
	private int departmentId;
	
	private String departmentName;
	
	private List<Category> categoryList;
	
	private boolean selected;

  public Department(int departmentId, String departmentName, List<Category> categoryList, boolean selected) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.categoryList = categoryList;
		this.selected = selected;
	}
	
	public Department() {
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
    
	  if(this.selected) {
	    categoryList.forEach(
	      cat -> {cat.setSelected(true);
	              cat.setDisabled(true);
	    }); 
	  }
		this.categoryList = categoryList;
	}
	
  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }
	

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", categoryList="
				+ categoryList + "]";
	}
	
	
	
}
