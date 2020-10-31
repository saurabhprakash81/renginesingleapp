package com.thematic.retail.rengine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_ATTRIBUTE")
public class ItemAttributes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;
	
	@Column(name = "ITEMKEY")
	private String itemKey;

	@Column(name = "ITEMNAME")
	private String itemName;

	@Column(name = "PRICE")
	private int price;
	
	@Column(name = "MARGIN")
	private int margin;
	
	@Column(name = "STOREREVENUE")
	private int storeRevenue;
	
	@Column(name = "DIGITALREVENUE")
	private int digitalRevenue;
	
	@Column(name = "RATINGREVIEW")
	private int ratingReview;
	
	@Column(name = "ABANDONMENTRATE")
	private int abandonmentRate;
	
	@Column(name = "QANDA")
	private int qAndA;
	
	@Column(name = "COMPLEXCITY")
	private int complexcity;
	
	@Column(name = "SUBSTITUTION")
	private int substitution;
	
	@Column(name = "RECENCY")
	private int recency;
	
	@Column(name = "CONTENTAVAILABILITY")
	private int contentAvailability;
	
	@Column(name = "PROMOTIONFREQUENCY")
	private int promotionFrequency;
	
	@Column(name = "INVENTORYSTATUS")
	private int inventoryStatus;
	
	@Column(name = "PRICEMATCHING")
	private boolean priceMatching;
	
	@Column(name = "CONTENTAVAILABLE")
	private boolean contentAvailable;
	
	@Column(name = "DEPARTMENT")
	private String department;
	
	@Column(name = "CATEGORY")
	private String category;
	
	@Column(name = "SUBCATEGORY")
	private String subCategory;
	
	@Column(name = "ITEMCLASS")
	private String itemClass;

	public ItemAttributes(String itemKey, String itemName, int price, int margin, int storeRevenue,
			int digitalRevenue, int ratingReview, int abandonmentRate, int qAndA, int complexcity, int substitution,
			int recency, int contentAvailability, int promotionFrequency, int inventoryStatus, boolean priceMatching,
			boolean contentAvailable, String department, String category, String subCategory, String itemClass) {
		super();
		this.itemKey = itemKey;
		this.itemName = itemName;
		this.price = price;
		this.margin = margin;
		this.storeRevenue = storeRevenue;
		this.digitalRevenue = digitalRevenue;
		this.ratingReview = ratingReview;
		this.abandonmentRate = abandonmentRate;
		this.qAndA = qAndA;
		this.complexcity = complexcity;
		this.substitution = substitution;
		this.recency = recency;
		this.contentAvailability = contentAvailability;
		this.promotionFrequency = promotionFrequency;
		this.inventoryStatus = inventoryStatus;
		this.priceMatching = priceMatching;
		this.contentAvailable = contentAvailable;
		this.department = department;
		this.category = category;
		this.subCategory = subCategory;
		this.itemClass = itemClass;
	}


	public ItemAttributes() {
		super();
	}

	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMargin() {
		return margin;
	}

	public void setMargin(int margin) {
		this.margin = margin;
	}

	public int getStoreRevenue() {
		return storeRevenue;
	}

	public void setStoreRevenue(int storeRevenue) {
		this.storeRevenue = storeRevenue;
	}

	public int getDigitalRevenue() {
		return digitalRevenue;
	}

	public void setDigitalRevenue(int digitalRevenue) {
		this.digitalRevenue = digitalRevenue;
	}

	public int getRatingReview() {
		return ratingReview;
	}

	public void setRatingReview(int ratingReview) {
		this.ratingReview = ratingReview;
	}

	public int getAbandonmentRate() {
		return abandonmentRate;
	}

	public void setAbandonmentRate(int abandonmentRate) {
		this.abandonmentRate = abandonmentRate;
	}

	public int getqAndA() {
		return qAndA;
	}

	public void setqAndA(int qAndA) {
		this.qAndA = qAndA;
	}

	public int getComplexcity() {
		return complexcity;
	}

	public void setComplexcity(int complexcity) {
		this.complexcity = complexcity;
	}

	public int getSubstitution() {
		return substitution;
	}

	public void setSubstitution(int substitution) {
		this.substitution = substitution;
	}

	public int getRecency() {
		return recency;
	}

	public void setRecency(int recency) {
		this.recency = recency;
	}

	public int getContentAvailability() {
		return contentAvailability;
	}

	public void setContentAvailability(int contentAvailability) {
		this.contentAvailability = contentAvailability;
	}

	public int getPromotionFrequency() {
		return promotionFrequency;
	}

	public void setPromotionFrequency(int promotionFrequency) {
		this.promotionFrequency = promotionFrequency;
	}

	public int getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(int inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public boolean isPriceMatching() {
		return priceMatching;
	}

	public void setPriceMatching(boolean priceMatching) {
		this.priceMatching = priceMatching;
	}

	public boolean isContentAvailable() {
		return contentAvailable;
	}

	public void setContentAvailable(boolean contentAvailable) {
		this.contentAvailable = contentAvailable;
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

	@Override
	public String toString() {
		return "ItemAttributes [ID=" + ID + ", itemKey=" + itemKey + ", itemName=" + itemName + ", price=" + price
				+ ", margin=" + margin + ", storeRevenue=" + storeRevenue + ", digitalRevenue=" + digitalRevenue
				+ ", ratingReview=" + ratingReview + ", abandonmentRate=" + abandonmentRate + ", qAndA=" + qAndA
				+ ", complexcity=" + complexcity + ", substitution=" + substitution + ", recency=" + recency
				+ ", contentAvailability=" + contentAvailability + ", promotionFrequency=" + promotionFrequency
				+ ", inventoryStatus=" + inventoryStatus + ", priceMatching=" + priceMatching + ", contentAvailable="
				+ contentAvailable + ", department=" + department + ", category=" + category + ", subCategory="
				+ subCategory + ", itemClass=" + itemClass + "]";
	}

}
