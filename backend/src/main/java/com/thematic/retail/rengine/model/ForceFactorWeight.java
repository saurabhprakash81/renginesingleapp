package com.thematic.retail.rengine.model;

import org.springframework.stereotype.Component;

@Component
public class ForceFactorWeight {

	// private String itemKey;

	private int priceWeight;

	private int marginWeight;

	private int storeRevenueWeight;

	private int digitalRevenueWeight;

	private int ratingReviewWeight;

	private int abandonmentRateWeight;

	private int qAndAWeight;

	private int complexcityWeight;

	private int substitutionWeight;

	private int recencyWeight;

	private int contentAvailabilityWeight;

	private int promotionFrequencyWeight;

	private int inventoryStatusWeight;

	private int priceMatchingWeight;

	private int contentAvailableWeight;

	public ForceFactorWeight(int priceWeight, int marginWeight, int storeRevenueWeight, int digitalRevenueWeight,
			int ratingReviewWeight, int abandonmentRateWeight, int qAndAWeight, int complexcityWeight,
			int substitutionWeight, int recencyWeight, int contentAvailabilityWeight, int promotionFrequencyWeight,
			int inventoryStatusWeight, int priceMatchingWeight, int contentAvailableWeight) {
		super();
		this.priceWeight = priceWeight;
		this.marginWeight = marginWeight;
		this.storeRevenueWeight = storeRevenueWeight;
		this.digitalRevenueWeight = digitalRevenueWeight;
		this.ratingReviewWeight = ratingReviewWeight;
		this.abandonmentRateWeight = abandonmentRateWeight;
		this.qAndAWeight = qAndAWeight;
		this.complexcityWeight = complexcityWeight;
		this.substitutionWeight = substitutionWeight;
		this.recencyWeight = recencyWeight;
		this.contentAvailabilityWeight = contentAvailabilityWeight;
		this.promotionFrequencyWeight = promotionFrequencyWeight;
		this.inventoryStatusWeight = inventoryStatusWeight;
		this.priceMatchingWeight = priceMatchingWeight;
		this.contentAvailableWeight = contentAvailableWeight;
	}

	public ForceFactorWeight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPriceWeight() {
		return priceWeight;
	}

	public void setPriceWeight(int priceWeight) {
		this.priceWeight = priceWeight;
	}

	public int getMarginWeight() {
		return marginWeight;
	}

	public void setMarginWeight(int marginWeight) {
		this.marginWeight = marginWeight;
	}

	public int getStoreRevenueWeight() {
		return storeRevenueWeight;
	}

	public void setStoreRevenueWeight(int storeRevenueWeight) {
		this.storeRevenueWeight = storeRevenueWeight;
	}

	public int getDigitalRevenueWeight() {
		return digitalRevenueWeight;
	}

	public void setDigitalRevenueWeight(int digitalRevenueWeight) {
		this.digitalRevenueWeight = digitalRevenueWeight;
	}

	public int getRatingReviewWeight() {
		return ratingReviewWeight;
	}

	public void setRatingReviewWeight(int ratingReviewWeight) {
		this.ratingReviewWeight = ratingReviewWeight;
	}

	public int getAbandonmentRateWeight() {
		return abandonmentRateWeight;
	}

	public void setAbandonmentRateWeight(int abandonmentRateWeight) {
		this.abandonmentRateWeight = abandonmentRateWeight;
	}

	public int getqAndAWeight() {
		return qAndAWeight;
	}

	public void setqAndAWeight(int qAndAWeight) {
		this.qAndAWeight = qAndAWeight;
	}

	public int getComplexcityWeight() {
		return complexcityWeight;
	}

	public void setComplexcityWeight(int complexcityWeight) {
		this.complexcityWeight = complexcityWeight;
	}

	public int getSubstitutionWeight() {
		return substitutionWeight;
	}

	public void setSubstitutionWeight(int substitutionWeight) {
		this.substitutionWeight = substitutionWeight;
	}

	public int getRecencyWeight() {
		return recencyWeight;
	}

	public void setRecencyWeight(int recencyWeight) {
		this.recencyWeight = recencyWeight;
	}

	public int getContentAvailabilityWeight() {
		return contentAvailabilityWeight;
	}

	public void setContentAvailabilityWeight(int contentAvailabilityWeight) {
		this.contentAvailabilityWeight = contentAvailabilityWeight;
	}

	public int getPromotionFrequencyWeight() {
		return promotionFrequencyWeight;
	}

	public void setPromotionFrequencyWeight(int promotionFrequencyWeight) {
		this.promotionFrequencyWeight = promotionFrequencyWeight;
	}

	public int getInventoryStatusWeight() {
		return inventoryStatusWeight;
	}

	public void setInventoryStatusWeight(int inventoryStatusWeight) {
		this.inventoryStatusWeight = inventoryStatusWeight;
	}

	public int getPriceMatchingWeight() {
		return priceMatchingWeight;
	}

	public void setPriceMatchingWeight(int priceMatchingWeight) {
		this.priceMatchingWeight = priceMatchingWeight;
	}

	public int getContentAvailableWeight() {
		return contentAvailableWeight;
	}

	public void setContentAvailableWeight(int contentAvailableWeight) {
		this.contentAvailableWeight = contentAvailableWeight;
	}

	@Override
	public String toString() {
		return "ForceFactorWeight [priceWeight=" + priceWeight + ", marginWeight=" + marginWeight
				+ ", storeRevenueWeight=" + storeRevenueWeight + ", digitalRevenueWeight=" + digitalRevenueWeight
				+ ", ratingReviewWeight=" + ratingReviewWeight + ", abandonmentRateWeight=" + abandonmentRateWeight
				+ ", qAndAWeight=" + qAndAWeight + ", complexcityWeight=" + complexcityWeight + ", substitutionWeight="
				+ substitutionWeight + ", recencyWeight=" + recencyWeight + ", contentAvailabilityWeight="
				+ contentAvailabilityWeight + ", promotionFrequencyWeight=" + promotionFrequencyWeight
				+ ", inventoryStatusWeight=" + inventoryStatusWeight + ", priceMatchingWeight=" + priceMatchingWeight
				+ ", contentAvailableWeight=" + contentAvailableWeight + "]";
	}

}
