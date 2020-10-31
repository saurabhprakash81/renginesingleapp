package com.thematic.retail.rengine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_SCORE_DATA_VALUES")
public class ItemScoreDataValues {

	@Id
	@Column(name = "itemscoredatavalue_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "ITEMKEY")
	private String itemKey;

	@Column(name = "ITEMNAME")
	private String itemName;

	@Column(name = "DEPARTMENT")
	private String department;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "SUBCATEGORY")
	private String subCategory;

	@Column(name = "ITEMCLASS")
	private String itemClass;

	@Column(name = "PRICE")
	private int price;

	@Column(name = "ABANDONMENTRATE")
	private int abandonmentRate;

	@Column(name = "SCORE")
	private double score;

	@Column(name = "ADJUSTEDSCORE")
	private double adjustedScore;

	@Column(name = "RECOMMMENDED")
	private String recommended;

	@Column(name = "OVERRIDE")
	private boolean override = false;

	public ItemScoreDataValues() {
	}

	public ItemScoreDataValues(String itemKey, String itemName, String department, String category, String subCategory,
			String itemClass, int price, int abandonmentRate, double score, double adjustedScore, String recommended,
			boolean override) {
		super();
		// this.id = id;
		this.itemKey = itemKey;
		this.itemName = itemName;
		this.department = department;
		this.category = category;
		this.subCategory = subCategory;
		this.itemClass = itemClass;
		this.price = price;
		this.abandonmentRate = abandonmentRate;
		this.score = score;
		this.adjustedScore = adjustedScore;
		this.recommended = recommended;
		this.override = override;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		return "ItemScoreDataValues [id=" + id + ", itemKey=" + itemKey + ", itemName=" + itemName + ", department="
				+ department + ", category=" + category + ", subCategory=" + subCategory + ", itemClass=" + itemClass
				+ ", price=" + price + ", abandonmentRate=" + abandonmentRate + ", score=" + score + ", adjustedScore="
				+ adjustedScore + ", recommended=" + recommended + ", override=" + override + "]";
	}

}
