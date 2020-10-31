package com.thematic.retail.rengine.model;

import java.util.List;

public class CategoryHierarchy {
	
	private List<Department> departmentList;
	
	public CategoryHierarchy(List<Department> departmentList) {
		super();
		this.departmentList = departmentList;
	}
	
	public CategoryHierarchy() {
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}

	@Override
	public String toString() {
		return "\nCategoryHierarchy [departmentList=" + departmentList + "]";
	}
	
	

}
