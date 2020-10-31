package com.thematic.retail.rengine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FORCE_FACTORS")
public class ForceFactor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long ID;
	
	@Column(name = "FORCEFACTOR_NAME")
	private String itemKey;

	@Column(name = "DEFAULT_WEIGHT")
	private String itemName;

	public ForceFactor(String itemKey, String itemName) {
		super();
		this.itemKey = itemKey;
		this.itemName = itemName;
	}

	public ForceFactor() {
		super();
	}

	public String getItemKey() {
		return itemKey;
	}

	public void setItemKey(String itemKey) {
		this.itemKey = itemKey;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "ForceFactor [ID=" + ID + ", itemKey=" + itemKey + ", itemName=" + itemName + "]";
	}

}
