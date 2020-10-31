package com.thematic.retail.rengine.util;

import com.thematic.retail.rengine.entity.ItemAttributes;
import com.thematic.retail.rengine.entity.ItemAttributesHiLoRule;
import com.thematic.retail.rengine.model.ForceFactorWeight;

public class AppCalculator {

	public static final int HIGH_RATING_VALUE = 5;
	public static final int MID_RATING_VALUE = 3;
	public static final int LOW_RATING_VALUE = 1;
	
	public static void main(String[] args) {
		ItemAttributes itemAttribute = new ItemAttributes("101123", "Linko King Bedsheet", 14, 5, 300, 200, 23, 4, 75, 1, 1, 1, 5, 1, 20, true, false,"","","","");
		ItemAttributesHiLoRule hiLoRule = new ItemAttributesHiLoRule("101123", "Linko King Bedsheet", 10, 15, 40, 60, 200, 1000, 200, 1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);
		ForceFactorWeight forceFactorWeight = new ForceFactorWeight(5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5);
		
		System.out.println("ItemName : " + itemAttribute.getItemName() + ", ItemKey : " + itemAttribute.getItemKey() + ", Score : " +calculateScore(itemAttribute, hiLoRule, forceFactorWeight));

		ItemAttributes itemAttribute2 = new ItemAttributes("54632", "Lambo Kids Bike- 18\"", 65, 20, 4500, 265, 5, 76, 4, 5, 5, 3, 1, 3, 3, true, true,"","","","");
		ItemAttributesHiLoRule hiLoRule2 = new ItemAttributesHiLoRule("54632", "Lambo Kids Bike- 18\"", 40, 70, 40, 60, 200, 1000, 200, 1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);	
		ForceFactorWeight forceFactorWeight2 = new ForceFactorWeight(20, 0, 0, 0, 10, 30, 5, 10, 0, 0, 0, 0, 5, 10, 10);
		
		System.out.println("ItemName : " + itemAttribute2.getItemName() + ", ItemKey : " + itemAttribute2.getItemKey() + ", Score : " +calculateScore(itemAttribute2, hiLoRule2, forceFactorWeight2));
		
	}
	
	public static double calculateScore(ItemAttributes itemAttribute, ItemAttributesHiLoRule hiLoRule, ForceFactorWeight forceFactorWeight ) {
		
		int commonRatingForPriceMatchContentAvaialble = ratingValueTranslator(itemAttribute.isPriceMatching(),itemAttribute.isContentAvailable());
		double score = (
				ratingValueTranslator(hiLoRule.getPriceLo(),hiLoRule.getPriceHi(), itemAttribute.getPrice()) * forceFactorWeight.getPriceWeight()) +
				ratingValueTranslator(hiLoRule.getMarginLo(),hiLoRule.getMarginHi(), itemAttribute.getMargin()) * forceFactorWeight.getMarginWeight() +
				ratingValueTranslator(hiLoRule.getStoreRevenueLo(),hiLoRule.getStoreRevenueHi(), itemAttribute.getStoreRevenue()) * forceFactorWeight.getStoreRevenueWeight() +
				ratingValueTranslator(hiLoRule.getDigitalRevenueLo(),hiLoRule.getDigitalRevenueHi(), itemAttribute.getDigitalRevenue())* forceFactorWeight.getDigitalRevenueWeight() +
				ratingValueTranslator(hiLoRule.getRatingReviewLo(),hiLoRule.getRatingReviewHi(), itemAttribute.getRatingReview())* forceFactorWeight.getRatingReviewWeight() +
				ratingValueTranslator(hiLoRule.getAbandonmentRateLo(),hiLoRule.getAbandonmentRateHi(), itemAttribute.getAbandonmentRate())* forceFactorWeight.getAbandonmentRateWeight() +
				ratingValueTranslator(hiLoRule.getqAndALo(),hiLoRule.getqAndAHi(), itemAttribute.getqAndA()) * forceFactorWeight.getqAndAWeight() +
				ratingValueTranslator(hiLoRule.getComplexcityLo(),hiLoRule.getComplexcityHi(), itemAttribute.getComplexcity()) * forceFactorWeight.getComplexcityWeight() +
				ratingValueTranslator(hiLoRule.getSubstitutionLo(),hiLoRule.getSubstitutionHi(), itemAttribute.getSubstitution()) * forceFactorWeight.getSubstitutionWeight() +
				ratingValueTranslator(hiLoRule.getRecencyLo(),hiLoRule.getRecencyHi(), itemAttribute.getRecency()) * forceFactorWeight.getRecencyWeight() +
				ratingValueTranslator(hiLoRule.getContentAvailabilityLo(),hiLoRule.getContentAvailabilityHi(), itemAttribute.getContentAvailability()) * forceFactorWeight.getContentAvailabilityWeight() +
				ratingValueTranslator(hiLoRule.getPromotionFrequencyLo(),hiLoRule.getPromotionFrequencyHi(), itemAttribute.getPromotionFrequency()) * forceFactorWeight.getPromotionFrequencyWeight() +
				ratingValueTranslator(hiLoRule.getInventoryStatusLo(),hiLoRule.getInventoryStatusLo(), itemAttribute.getInventoryStatus()) * forceFactorWeight.getInventoryStatusWeight() +				
//				ratingValueTranslator(itemAttribute.isPriceMatching()) * forceFactorWeight.getPriceMatchingWeight() +
//				ratingValueTranslator(itemAttribute.isContentAvailable()) * forceFactorWeight.getContentAvailableWeight();
				commonRatingForPriceMatchContentAvaialble * forceFactorWeight.getPriceMatchingWeight() +
				commonRatingForPriceMatchContentAvaialble * forceFactorWeight.getContentAvailableWeight();		
		return score/100;
	}
	
	public static int ratingValueTranslator(int minValue, int maxValue, int value) {
		if (value <= minValue) {
			return LOW_RATING_VALUE;
		} else if (value >= maxValue) {
			return HIGH_RATING_VALUE;
		}
		return MID_RATING_VALUE;
	}

	public static int ratingValueTranslator(boolean value1, boolean value2) {
		if (value1 && value2) {
			return HIGH_RATING_VALUE;
		} else if ((value1 && !value2) || !value1 && value2) {
			return MID_RATING_VALUE;
		}
		return MID_RATING_VALUE;
	}

	public static int ratingValueTranslator(boolean value) {
		return value ? HIGH_RATING_VALUE : LOW_RATING_VALUE;
	}

}
