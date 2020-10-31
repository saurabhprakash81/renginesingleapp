package com.thematic.retail.rengine.model;

public class ItemClass {
	
	private int itemClassId;
	
	private String itemClassName;
	
	private boolean selected;
	
	private boolean disabled;

	public int getItemClassId() {
		return itemClassId;
	}

	public ItemClass(int itemClassId, String itemClassName, boolean selected) {
		super();
		this.itemClassId = itemClassId;
		this.itemClassName = itemClassName;
		this.selected = selected;
	}

	public ItemClass() {
	}

	public void setItemClassId(int itemClassId) {
		this.itemClassId = itemClassId;
	}

	public String getItemClassName() {
		return itemClassName;
	}

	public void setItemClassName(String itemClassName) {
		this.itemClassName = itemClassName;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
  public boolean isDisabled() {
    return disabled;
  }


  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }
	

	@Override
	public String toString() {
		return "ItemClass [itemClassId=" + itemClassId + ", itemClassName=" + itemClassName + ", selected=" + selected
				+ "]";
	}

}
