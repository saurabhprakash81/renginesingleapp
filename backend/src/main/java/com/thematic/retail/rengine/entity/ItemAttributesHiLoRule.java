package com.thematic.retail.rengine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_ATTRIBUTE_HILO")
public class ItemAttributesHiLoRule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long ID;
	
	@Column(name = "ITEMKEY")
	private String itemKey;

	@Column(name = "ITEMNAME")
	private String itemName;
	
	@Column(name = "PRICE_LO")
	private int priceLo;
	
	@Column(name = "PRICE_HI")
	private int priceHi;
	
	@Column(name = "MARGIN_LO")
	private int marginLo;
	
	@Column(name = "MARGIN_HI")
	private int marginHi;
	
	@Column(name = "STOREREVENUE_LO")
	private int storeRevenueLo;
	
	@Column(name = "STOREREVENUE_HI")
	private int storeRevenueHi;
	
	@Column(name = "DIGITALREVENUE_LO")
	private int digitalRevenueLo;
	
	@Column(name = "DIGITALREVENUE_HI")
	private int digitalRevenueHi;
	
	@Column(name = "RATINGREVIEW_LO")
	private int ratingReviewLo;
	
	@Column(name = "RATINGREVIEW_HI")
	private int ratingReviewHi;
	
	@Column(name = "ABANDONMENTRATE_LO")
	private int abandonmentRateLo;
	
	@Column(name = "ABANDONMENTRATE_HI")
	private int abandonmentRateHi;
	
	@Column(name = "QANDA_LO")
	private int qAndALo;
	
	@Column(name = "QANDA_HI")
	private int qAndAHi;
	
	@Column(name = "COMPLEXCITY_LO")
	private int complexcityLo;
	
	@Column(name = "COMPLEXCITY_HI")
	private int complexcityHi;
	
	@Column(name = "SUBSTITUTION_LO")
	private int substitutionLo;
	
	@Column(name = "SUBSTITUTION_HI")
	private int substitutionHi;
	
	@Column(name = "RECENCY_LO")
	private int recencyLo;
	
	@Column(name = "RECENCY_HI")
	private int recencyHi;
	
	@Column(name = "CONTENTAVAILABILITY_LO")
	private int contentAvailabilityLo;
	
	@Column(name = "CONTENTAVAILABILITY_HI")
	private int contentAvailabilityHi;
	
	@Column(name = "PROMOTIONFREQUENCY_LO")
	private int promotionFrequencyLo;
	
	@Column(name = "PROMOTIONFREQUENCY_HI")
	private int promotionFrequencyHi;
	
	@Column(name = "INVENTORYSTATUS_LO")	
	private int inventoryStatusLo;
	
	@Column(name = "INVENTORYSTATUS_HI")
	private int inventoryStatusHi;
	
	@Column(name = "PRICEMATCHING")
	private boolean priceMatching;
	
	@Column(name = "CONTENTAVAILABLE")
	private boolean contentAvailable;
	
	public ItemAttributesHiLoRule(String itemKey, String itemName, int priceLo, int priceHi, int marginLo, int marginHi,
			int storeRevenueLo, int storeRevenueHi, int digitalRevenueLo, int digitalRevenueHi, int ratingReviewLo,
			int ratingReviewHi, int abandonmentRateLo, int abandonmentRateHi, int qAndALo, int qAndAHi,
			int complexcityLo, int complexcityHi, int substitutionLo, int substitutionHi, int recencyLo, int recencyHi,
			int contentAvailabilityLo, int contentAvailabilityHi, int promotionFrequencyLo, int promotionFrequencyHi,
			int inventoryStatusLo, int inventoryStatusHi, boolean priceMatching, boolean contentAvailable) {
		super();
		this.itemKey = itemKey;
		this.itemName = itemName;
		this.priceLo = priceLo;
		this.priceHi = priceHi;
		this.marginLo = marginLo;
		this.marginHi = marginHi;
		this.storeRevenueLo = storeRevenueLo;
		this.storeRevenueHi = storeRevenueHi;
		this.digitalRevenueLo = digitalRevenueLo;
		this.digitalRevenueHi = digitalRevenueHi;
		this.ratingReviewLo = ratingReviewLo;
		this.ratingReviewHi = ratingReviewHi;
		this.abandonmentRateLo = abandonmentRateLo;
		this.abandonmentRateHi = abandonmentRateHi;
		this.qAndALo = qAndALo;
		this.qAndAHi = qAndAHi;
		this.complexcityLo = complexcityLo;
		this.complexcityHi = complexcityHi;
		this.substitutionLo = substitutionLo;
		this.substitutionHi = substitutionHi;
		this.recencyLo = recencyLo;
		this.recencyHi = recencyHi;
		this.contentAvailabilityLo = contentAvailabilityLo;
		this.contentAvailabilityHi = contentAvailabilityHi;
		this.promotionFrequencyLo = promotionFrequencyLo;
		this.promotionFrequencyHi = promotionFrequencyHi;
		this.inventoryStatusLo = inventoryStatusLo;
		this.inventoryStatusHi = inventoryStatusHi;
		this.priceMatching = priceMatching;
		this.contentAvailable = contentAvailable;
	}

	public ItemAttributesHiLoRule() {
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

	public int getPriceLo() {
		return priceLo;
	}

	public void setPriceLo(int priceLo) {
		this.priceLo = priceLo;
	}

	public int getPriceHi() {
		return priceHi;
	}

	public void setPriceHi(int priceHi) {
		this.priceHi = priceHi;
	}

	public int getMarginLo() {
		return marginLo;
	}

	public void setMarginLo(int marginLo) {
		this.marginLo = marginLo;
	}

	public int getMarginHi() {
		return marginHi;
	}

	public void setMarginHi(int marginHi) {
		this.marginHi = marginHi;
	}

	public int getStoreRevenueLo() {
		return storeRevenueLo;
	}

	public void setStoreRevenueLo(int storeRevenueLo) {
		this.storeRevenueLo = storeRevenueLo;
	}

	public int getStoreRevenueHi() {
		return storeRevenueHi;
	}

	public void setStoreRevenueHi(int storeRevenueHi) {
		this.storeRevenueHi = storeRevenueHi;
	}

	public int getDigitalRevenueLo() {
		return digitalRevenueLo;
	}

	public void setDigitalRevenueLo(int digitalRevenueLo) {
		this.digitalRevenueLo = digitalRevenueLo;
	}

	public int getDigitalRevenueHi() {
		return digitalRevenueHi;
	}

	public void setDigitalRevenueHi(int digitalRevenueHi) {
		this.digitalRevenueHi = digitalRevenueHi;
	}

	public int getRatingReviewLo() {
		return ratingReviewLo;
	}

	public void setRatingReviewLo(int ratingReviewLo) {
		this.ratingReviewLo = ratingReviewLo;
	}

	public int getRatingReviewHi() {
		return ratingReviewHi;
	}

	public void setRatingReviewHi(int ratingReviewHi) {
		this.ratingReviewHi = ratingReviewHi;
	}

	public int getAbandonmentRateLo() {
		return abandonmentRateLo;
	}

	public void setAbandonmentRateLo(int abandonmentRateLo) {
		this.abandonmentRateLo = abandonmentRateLo;
	}

	public int getAbandonmentRateHi() {
		return abandonmentRateHi;
	}

	public void setAbandonmentRateHi(int abandonmentRateHi) {
		this.abandonmentRateHi = abandonmentRateHi;
	}

	public int getqAndALo() {
		return qAndALo;
	}

	public void setqAndALo(int qAndALo) {
		this.qAndALo = qAndALo;
	}

	public int getqAndAHi() {
		return qAndAHi;
	}

	public void setqAndAHi(int qAndAHi) {
		this.qAndAHi = qAndAHi;
	}

	public int getComplexcityLo() {
		return complexcityLo;
	}

	public void setComplexcityLo(int complexcityLo) {
		this.complexcityLo = complexcityLo;
	}

	public int getComplexcityHi() {
		return complexcityHi;
	}

	public void setComplexcityHi(int complexcityHi) {
		this.complexcityHi = complexcityHi;
	}

	public int getSubstitutionLo() {
		return substitutionLo;
	}

	public void setSubstitutionLo(int substitutionLo) {
		this.substitutionLo = substitutionLo;
	}

	public int getSubstitutionHi() {
		return substitutionHi;
	}

	public void setSubstitutionHi(int substitutionHi) {
		this.substitutionHi = substitutionHi;
	}

	public int getRecencyLo() {
		return recencyLo;
	}

	public void setRecencyLo(int recencyLo) {
		this.recencyLo = recencyLo;
	}

	public int getRecencyHi() {
		return recencyHi;
	}

	public void setRecencyHi(int recencyHi) {
		this.recencyHi = recencyHi;
	}

	public int getContentAvailabilityLo() {
		return contentAvailabilityLo;
	}

	public void setContentAvailabilityLo(int contentAvailabilityLo) {
		this.contentAvailabilityLo = contentAvailabilityLo;
	}

	public int getContentAvailabilityHi() {
		return contentAvailabilityHi;
	}

	public void setContentAvailabilityHi(int contentAvailabilityHi) {
		this.contentAvailabilityHi = contentAvailabilityHi;
	}

	public int getPromotionFrequencyLo() {
		return promotionFrequencyLo;
	}

	public void setPromotionFrequencyLo(int promotionFrequencyLo) {
		this.promotionFrequencyLo = promotionFrequencyLo;
	}

	public int getPromotionFrequencyHi() {
		return promotionFrequencyHi;
	}

	public void setPromotionFrequencyHi(int promotionFrequencyHi) {
		this.promotionFrequencyHi = promotionFrequencyHi;
	}

	public int getInventoryStatusLo() {
		return inventoryStatusLo;
	}

	public void setInventoryStatusLo(int inventoryStatusLo) {
		this.inventoryStatusLo = inventoryStatusLo;
	}

	public int getInventoryStatusHi() {
		return inventoryStatusHi;
	}

	public void setInventoryStatusHi(int inventoryStatusHi) {
		this.inventoryStatusHi = inventoryStatusHi;
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

	@Override
	public String toString() {
		return "ItemAttributesHiLoRule [ID=" + ID + ", itemKey=" + itemKey + ", itemName=" + itemName + ", priceLo="
				+ priceLo + ", priceHi=" + priceHi + ", marginLo=" + marginLo + ", marginHi=" + marginHi
				+ ", storeRevenueLo=" + storeRevenueLo + ", storeRevenueHi=" + storeRevenueHi + ", digitalRevenueLo="
				+ digitalRevenueLo + ", digitalRevenueHi=" + digitalRevenueHi + ", ratingReviewLo=" + ratingReviewLo
				+ ", ratingReviewHi=" + ratingReviewHi + ", abandonmentRateLo=" + abandonmentRateLo
				+ ", abandonmentRateHi=" + abandonmentRateHi + ", qAndALo=" + qAndALo + ", qAndAHi=" + qAndAHi
				+ ", complexcityLo=" + complexcityLo + ", complexcityHi=" + complexcityHi + ", substitutionLo="
				+ substitutionLo + ", substitutionHi=" + substitutionHi + ", recencyLo=" + recencyLo + ", recencyHi="
				+ recencyHi + ", contentAvailabilityLo=" + contentAvailabilityLo + ", contentAvailabilityHi="
				+ contentAvailabilityHi + ", promotionFrequencyLo=" + promotionFrequencyLo + ", promotionFrequencyHi="
				+ promotionFrequencyHi + ", inventoryStatusLo=" + inventoryStatusLo + ", inventoryStatusHi="
				+ inventoryStatusHi + ", priceMatching=" + priceMatching + ", contentAvailable=" + contentAvailable
				+ "]";
	}
	
}
