package com.thematic.retail.rengine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thematic.retail.rengine.model.ItemScore;
import com.thematic.retail.rengine.service.ItemScoreDataValuesService;
import com.thematic.retail.rengine.util.FileIOUtils;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DashboardController {

	@Autowired
	private ItemScoreDataValuesService itemScoreDataValuesService;
	
	@GetMapping("/dashboard")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<List<ItemScore>> getItemScore(){
		List<ItemScore> itemScoreList = itemScoreDataValuesService.getItemScoreList();
		if(itemScoreList !=null) {
			return ResponseEntity.ok(itemScoreList);
		} else {
			return (ResponseEntity<List<ItemScore>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/dashboard")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<List<ItemScore>> setItemScore(@RequestBody List<ItemScore> itemScoreList) {
		System.out.println("inside post dashboard");
		List<ItemScore> itemScore1 = itemScoreDataValuesService.updateItemScoreDataValues(itemScoreList);
		if (itemScore1 != null) {
			FileIOUtils.writeCSVFile(itemScoreList);
			return ResponseEntity.ok(itemScore1);
		} else {
			return (ResponseEntity<List<ItemScore>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}
	
//	private List<ItemScore> runOnTestData() {
//		
//		List<ItemScore> itemScoreList = new ArrayList<ItemScore>();
//
//		List<ItemAttributes> itemAttributesList = itemAttributeService.getAllItemAttributes();
//		List<ItemAttributesHiLoRule> itemAttributesHiLoList =  itemAttributeHiLoRuleService.getAllItemAttributeHiLoRule();
//		//ForceFactorWeight forceFactorWeight = new ForceFactorWeight(5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5);
//		ForceFactorWeight forceFactorWeight = forceFactorService.getForceFactorWeight();		
//		System.out.println(forceFactorWeight.toString());
//		ItemAttributes itemAttribute;
//		ItemAttributesHiLoRule hiLoRule;
//		ItemScore itemScore;
//		for(int i =0; i< itemAttributesList.size(); i++) {
//			itemAttribute = itemAttributesList.get(i);
//			hiLoRule = itemAttributesHiLoList.get(i);
//			double score = AppCalculator.calculateScore(itemAttribute, hiLoRule, forceFactorWeight);
//			double adjustedScore = 0.0; //need to calculate based upon algorithm
//			boolean isrecommended = score >= 2.5 ; //will be calulated based upon score and adjusted score
//			String recommended = null;
//			recommended = isrecommended?"Y":"N";
//			boolean override = false;
//			itemScore = new ItemScore(itemAttribute.getItemKey(),itemAttribute.getItemName(), itemAttribute.getDepartment(), itemAttribute.getCategory(), itemAttribute.getSubCategory(),
//					itemAttribute.getItemClass(), itemAttribute.getPrice(), itemAttribute.getAbandonmentRate(), score, adjustedScore, recommended, override);
//			itemScoreList.add(itemScore);
////			System.out.println("ItemAttribute : " + itemAttribute);
////			System.out.println("HiLoRule : " + hiLoRule);
////			System.out.println("ForceFactor : " + forceFactorWeight);
////			
////			System.out.println("\nScore for + " + itemAttribute.getItemName() + ", ItemKey : " + itemAttribute.getId() + " = " + score);
//		}
//		return itemScoreList;
//		
//	}

	
//	private void prepareDummyTestData() {
//		List<ItemAttributes> itemAttributesList =  new ArrayList<ItemAttributes>();
//		List<ItemAttributesHiLoRule> itemAttributesHiLoList =  new ArrayList<ItemAttributesHiLoRule>();
//		
//		ItemAttributes itemAttribute;
//		ItemAttributesHiLoRule hiLoRule;
//
//		for (int i = 0; i < NUM_OF_RECORD_FOR_TEST; i++) {
//			itemAttribute = new ItemAttributes("" + i, i + " Linko Queen Bedsheet", 14, 5, 300, 200, 23, 4, 75, 1, 1, 1, 5, 1, 20, true, false);
//			hiLoRule = new ItemAttributesHiLoRule("" + i, i + " Linko Queen Bedsheet", 10, 15, 40, 60, 200, 1000, 200, 1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);
////			System.out.println(itemAttribute.getId() +","+ itemAttribute.getItemName()+","+itemAttribute.getPrice()+","+ itemAttribute.getMargin()+","+ itemAttribute.getStoreRevenue()
////			+","+ itemAttribute.getDigitalRevenue()+","+ itemAttribute.getRatingReview()+","+ itemAttribute.getAbandonmentRate()+","+ itemAttribute.getqAndA()+","+ itemAttribute.getComplexcity()
////			+","+ itemAttribute.getSubstitution()+","+ itemAttribute.getRecency()+","+ itemAttribute.getContentAvailability()+","+ itemAttribute.getPromotionFrequency()
////			+","+ itemAttribute.getInventoryStatus()+","+ itemAttribute.isPriceMatching()+","+ itemAttribute.isContentAvailable());
////			itemAttributesList.add(itemAttribute);
////			itemAttributesHiLoList.add(hiLoRule);
//
////			System.out.println(hiLoRule.getId()+","+hiLoRule.getItemName()+","+hiLoRule.getPriceLo()+","+hiLoRule.getPriceHi()+ "," +hiLoRule.getMarginLo()+ "," + hiLoRule.getMarginHi()
////			+ "," + hiLoRule.getStoreRevenueLo()+ "," + hiLoRule.getStoreRevenueHi()+ "," + hiLoRule.getDigitalRevenueLo()+ "," + hiLoRule.getDigitalRevenueHi()+ "," + hiLoRule.getRatingReviewLo()+ "," + hiLoRule.getRatingReviewHi()
////			+ "," + hiLoRule.getAbandonmentRateLo()+ "," + hiLoRule.getAbandonmentRateHi()+ "," + hiLoRule.getqAndALo()+ "," + hiLoRule.getqAndAHi()+ "," + hiLoRule.getComplexcityLo()+ "," + hiLoRule.getComplexcityHi()
////			+ "," + hiLoRule.getSubstitutionLo()+ "," + hiLoRule.getSubstitutionHi()+ "," + hiLoRule.getRecencyLo()+ "," + hiLoRule.getRecencyHi()+ "," + hiLoRule.getContentAvailabilityLo()+ "," + hiLoRule.getContentAvailabilityHi()
////			+ "," + hiLoRule.getPromotionFrequencyLo()+ "," + hiLoRule.getPromotionFrequencyHi()+ "," + hiLoRule.getInventoryStatusLo()+ "," + hiLoRule.getInventoryStatusHi()+ "," + hiLoRule.isPriceMatching() + "," + hiLoRule.isContentAvailable());
//			itemAttributesList.add(itemAttribute);
//			itemAttributesHiLoList.add(hiLoRule);
//			
//		}
//		
//		itemAttributeService.addItemAttribute(itemAttributesList);
//		itemAttributeHiLoRuleService.addItemAttributeHiLoRule(itemAttributesHiLoList);
//	}

	
//	private void initializeAppData() {
//		ItemAttributes itemAttribute = new ItemAttributes("101123", "Linko Queen Bedsheet", 14, 5, 300, 200, 23, 4, 75, 1, 1, 1, 5, 1, 20, true, false);
//		ItemAttributesHiLoRule hiLoRule = new ItemAttributesHiLoRule("101123", "Linko Queen Bedsheet", 10, 15, 40, 60, 200, 1000, 200, 1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);	
//		ForceFactorWeight forceFactorWeight = new ForceFactorWeight(5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5);
//		
//		//System.out.println("ItemName : " + itemAttribute.getItemName() + ", ItemKey : " + itemAttribute.getId() + ", Score : " +calculateScore(itemAttribute, hiLoRule, forceFactorWeight));
//
//		ItemAttributes itemAttribute2 = new ItemAttributes("54632", "Lambo Kids Bike- 18\"", 65, 20, 4500, 265, 5, 76, 4, 5, 5, 3, 1, 3, 3, true, true);
//		ItemAttributesHiLoRule hiLoRule2 = new ItemAttributesHiLoRule("54632", "Lambo Kids Bike- 18\"", 40, 70, 40, 60, 200, 1000, 200, 1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);	
//		ForceFactorWeight forceFactorWeight2 = new ForceFactorWeight(20, 0, 0, 0, 10, 30, 5, 10, 0, 0, 0, 0, 5, 10, 10);
//		
//		//System.out.println("ItemName : " + itemAttribute2.getItemName() + ", ItemKey : " + itemAttribute2.getId() + ", Score : " +calculateScore(itemAttribute2, hiLoRule2, forceFactorWeight2));
//
//	
//		List<ItemAttributes> itemAttributesList =  new ArrayList<ItemAttributes>();
//		itemAttributesList.add(itemAttribute);
//		itemAttributesList.add(itemAttribute2);
//
//		List<ItemAttributesHiLoRule> itemAttributesHiLoList =  new ArrayList<ItemAttributesHiLoRule>();
//		itemAttributesHiLoList.add(hiLoRule);
//		itemAttributesHiLoList.add(hiLoRule2);
//		
//		itemAttributeService.addItemAttribute(itemAttributesList);
//		itemAttributeHiLoRuleService.addItemAttributeHiLoRule(itemAttributesHiLoList);
//		
//		List<ForceFactorWeight> forceFactorWeightList =  new ArrayList<ForceFactorWeight>();
//		forceFactorWeightList.add(forceFactorWeight);
//		forceFactorWeightList.add(forceFactorWeight2);
//	}
	
//	private void runOnTestData() {
////ItemAttributes itemAttribute = new ItemAttributes("101123", "Linko Queen Bedsheet", 14, 5, 300, 200, 23, 4, 75, 1, 1, 1, 5, 1, 20, true, false);
////ItemAttributesHiLoRule hiLoRule = new ItemAttributesHiLoRule("101123", "Linko Queen Bedsheet", 10, 15, 40, 60, 200, 1000, 200, 1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);	
//ForceFactorWeight forceFactorWeight = new ForceFactorWeight(5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5);
//
////System.out.println("ItemName : " + itemAttribute.getItemName() + ", ItemKey : " + itemAttribute.getId() + ", Score : " +calculateScore(itemAttribute, hiLoRule, forceFactorWeight));
//
////ItemAttributes itemAttribute2 = new ItemAttributes("54632", "Lambo Kids Bike- 18\"", 65, 20, 4500, 265, 5, 76, 4, 5, 5, 3, 1, 3, 3, true, true);
////ItemAttributesHiLoRule hiLoRule2 = new ItemAttributesHiLoRule("54632", "Lambo Kids Bike- 18\"", 40, 70, 40, 60, 200, 1000, 200, 1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);	
//ForceFactorWeight forceFactorWeight2 = new ForceFactorWeight(20, 0, 0, 0, 10, 30, 5, 10, 0, 0, 0, 0, 5, 10, 10);
//
////System.out.println("ItemName : " + itemAttribute2.getItemName() + ", ItemKey : " + itemAttribute2.getId() + ", Score : " +calculateScore(itemAttribute2, hiLoRule2, forceFactorWeight2));
//
//List<ItemAttributes> itemAttributesList = itemAttributeService.getAllItemAttributes();
//List<ItemAttributesHiLoRule> itemAttributesHiLoList =  itemAttributeHiLoRuleService.getAllItemAttributeHiLoRule();
//List<ForceFactorWeight> forceFactorWeightList =  new ArrayList<ForceFactorWeight>();
//forceFactorWeightList.add(forceFactorWeight);
//forceFactorWeightList.add(forceFactorWeight2);
//
//ItemAttributes itemAttribute;
//ItemAttributesHiLoRule hiLoRule;
//ForceFactorWeight forceFactorWeightValue;
//for(int i =0; i< itemAttributesList.size(); i++) {
//	itemAttribute = itemAttributesList.get(i);
//	hiLoRule = itemAttributesHiLoList.get(i);
//	//forceFactorWeightValue = forceFactorWeightList.get(i);
//	System.out.println("ItemAttribute : " + itemAttribute);
//	System.out.println("HiLoRule : " + hiLoRule);
//	System.out.println("ForceFactor : " + forceFactorWeight);
//	
//	System.out.println("\nScore for + " + itemAttribute.getItemName() + ", ItemKey : " + itemAttribute.getId() + " = " + AppCalculator.calculateScore(itemAttribute, hiLoRule, forceFactorWeight));
//}
//
//}






}
