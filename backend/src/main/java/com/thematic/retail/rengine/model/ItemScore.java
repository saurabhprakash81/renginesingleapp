package com.thematic.retail.rengine.model;

public class ItemScore {

	private int id;
	
	private String itemKey;

	private String itemName;
	
	private String department;
	
	private String category;
	
	private String subCategory;
	
	private String itemClass;
	
	private int cost;
	
	private int abandonmentRate;
	
	private double score;
	
	private double adjustedScore;
	
	private String recommended;
	
	private boolean override =false;
	
	public ItemScore(int id, String itemKey, String itemName, String department, String category, String subCategory,
					 String itemClass, int cost, int abandonmentRate, double score, double adjustedScore, String recommended,
					 boolean override) {
		super();
		this.id = id;
		this.itemKey = itemKey;
		this.itemName = itemName;
		this.department = department;
		this.category = category;
		this.subCategory = subCategory;
		this.itemClass = itemClass;
		this.cost = cost;
		this.abandonmentRate = abandonmentRate;
		this.score = score;
		this.adjustedScore = adjustedScore;
		this.recommended = recommended;
		this.override = override;
	}

	public ItemScore() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getItemClass() {
		return itemClass;
	}

	public void setItemClass(String itemClass) {
		this.itemClass = itemClass;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAbandonmentRate() {
		return abandonmentRate;
	}

	public void setAbandonmentRate(int abandonmentRate) {
		this.abandonmentRate = abandonmentRate;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getAdjustedScore() {
		return adjustedScore;
	}

	public void setAdjustedScore(double adjustedScore) {
		this.adjustedScore = adjustedScore;
	}

	public String getRecommended() {
		return recommended;
	}

	public void setRecommended(String recommended) {
		this.recommended = recommended;
	}

	public boolean isOverride() {
		return override;
	}

	public void setOverride(boolean override) {
		this.override = override;
	}

	@Override
	public String toString() {
		return "ItemScore [id=" + id + ", itemKey=" + itemKey + ", itemName=" + itemName + ", department=" + department
				+ ", category=" + category + ", subCategory=" + subCategory + ", itemClass=" + itemClass + ", cost="
				+ cost + ", abandonmentRate=" + abandonmentRate + ", score=" + score + ", adjustedScore="
				+ adjustedScore + ", recommended=" + recommended + ", override=" + override + "]";
	}

}
