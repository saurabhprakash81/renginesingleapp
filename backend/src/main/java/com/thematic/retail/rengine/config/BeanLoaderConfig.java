package com.thematic.retail.rengine.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thematic.retail.rengine.entity.ItemAttributes;
import com.thematic.retail.rengine.entity.ItemAttributesHiLoRule;
import com.thematic.retail.rengine.entity.ItemScoreDataValues;
import com.thematic.retail.rengine.entity.Role;
import com.thematic.retail.rengine.entity.User;
import com.thematic.retail.rengine.model.ForceFactorWeight;
import com.thematic.retail.rengine.service.ForceFactorService;
import com.thematic.retail.rengine.service.ItemAttributeHiLoRuleService;
import com.thematic.retail.rengine.service.ItemAttributeService;
import com.thematic.retail.rengine.service.ItemScoreDataValuesService;
import com.thematic.retail.rengine.service.MyUserDetailService;
import com.thematic.retail.rengine.util.AppCalculator;

@Configuration
public class BeanLoaderConfig {

	private static final int NUM_OF_RECORD_FOR_TEST = 5;

	@Autowired
	private MyUserDetailService userService;

	@Autowired
	private ItemAttributeService itemAttributeService;

	@Autowired
	private ItemAttributeHiLoRuleService itemAttributeHiLoRuleService;

	@Autowired
	private ItemScoreDataValuesService itemScoreDataValuesService;
	
	@Autowired
	private ForceFactorService forceFactorService;
	

	@Bean
	public void initializeUserData() {

//		INSERT INTO `roles` (`name`) VALUES ('USER');
//		INSERT INTO `roles` (`name`) VALUES ('ADMIN');

//		INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('patrick', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.', '1');
//		INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('alex', '$2a$10$.tP2OH3dEG0zms7vek4ated5AiQ.EGkncii0OpCcGq4bckS9NOULu', '1');

		Role roleUser = new Role("USER");
		Role roleAdmin = new Role("ADMIN");

		Set<Role> rolesSet1 = new HashSet<Role>();
		rolesSet1.add(roleAdmin);

		Set<Role> rolesSet2 = new HashSet<Role>();
		rolesSet2.add(roleUser);

		List<User> users = new ArrayList<User>();
		users.add(new User("admin", "admin", true, rolesSet1));
		users.add(new User("user", "user", true, rolesSet2));
		userService.addUsers(users);
	}

	@Bean
	public void initializeItemData() {
		List<ItemAttributes> itemAttributesList = new ArrayList<ItemAttributes>();
		List<ItemAttributesHiLoRule> itemAttributesHiLoList = new ArrayList<ItemAttributesHiLoRule>();

		ItemAttributes itemAttribute;
		ItemAttributesHiLoRule hiLoRule;

//		String[] deptArr = {",Furniture,BedRoom,Bed,WoodFrame",
//				",Furniture,BedRoom,Bed,Metal Frame",
//				",Furniture,BedRoom,Chest,With drawer",
//				",Furniture,BedRoom,Chest,Without drawer",
//				",Furniture,Living Room,Sofa,Sectional",
//				",Furniture,Living Room,Sofa,Love Seat",
//				",Furniture,Living Room,Tables,Coffee table",
//				",Furniture,Living Room,Tables,End Tables",
//				",Garden,Plant,Outdoor Plants,Perinnials",
//				",Garden,Plant,Outdoor Plants,Seasonals",
//				",Garden,Equipemnt,Outdoor Gardening,Hoses",
//				",Garden,Equipemnt,Outdoor Gardening,Shovels" };

		for (int i = 0; i < NUM_OF_RECORD_FOR_TEST; i++) {
			itemAttribute = new ItemAttributes("" + i, i + " Linko King Bedsheet", 14, 5, 300, 200, 23, 4, 75, 1, 1, 1,
					5, 1, 20, true, false, "Dept", "Category", "SubCategory", "ItemClass");
			hiLoRule = new ItemAttributesHiLoRule("" + i, i + " Linko King Bedsheet", 10, 15, 40, 60, 200, 1000, 200,
					1000, 10, 20, 10, 40, 10, 20, 1, 5, 1, 5, 1, 5, 1, 5, 1, 5, 3, 5, true, false);
			itemAttributesList.add(itemAttribute);
			itemAttributesHiLoList.add(hiLoRule);

//			System.out.println(itemAttribute.getId() + "," + itemAttribute.getItemName() + ","
//					+ itemAttribute.getPrice() + "," + itemAttribute.getMargin() + "," + itemAttribute.getStoreRevenue()
//					+ "," + itemAttribute.getDigitalRevenue() + "," + itemAttribute.getRatingReview() + ","
//					+ itemAttribute.getAbandonmentRate() + "," + itemAttribute.getqAndA() + ","
//					+ itemAttribute.getComplexcity() + "," + itemAttribute.getSubstitution() + ","
//					+ itemAttribute.getRecency() + "," + itemAttribute.getContentAvailability() + ","
//					+ itemAttribute.getPromotionFrequency() + "," + itemAttribute.getInventoryStatus() + ","
//					+ itemAttribute.isPriceMatching() + "," + itemAttribute.isContentAvailable() + deptArr[(int) ((Math.random() * (11 - 0)) + 0) ]);
		}

		itemAttributeService.addItemAttribute(itemAttributesList);
		itemAttributeHiLoRuleService.addItemAttributeHiLoRule(itemAttributesHiLoList);
		forceFactorService.runRECalculation();
		//runRECalculationOnData();
	}

//	private void runRECalculationOnData() {
//		List<ItemScoreDataValues> itemScoreDataValuesList = new ArrayList<ItemScoreDataValues>();
//		List<ItemAttributes> itemAttributesList = itemAttributeService.getAllItemAttributes();
//		List<ItemAttributesHiLoRule> itemAttributesHiLoList = itemAttributeHiLoRuleService
//				.getAllItemAttributeHiLoRule();
//		ForceFactorWeight forceFactorWeight = new ForceFactorWeight(5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5);
//		// ForceFactorWeight forceFactorWeight = forceFactorService.getForceFactorWeight();
//		// System.out.println(forceFactorWeight.toString());
//		ItemAttributes itemAttribute;
//		ItemAttributesHiLoRule hiLoRule;
//		ItemScoreDataValues itemScoreDataValues;
//		for (int i = 0; i < itemAttributesList.size(); i++) {
//			itemAttribute = itemAttributesList.get(i);
//			hiLoRule = itemAttributesHiLoList.get(i);
//			double score = AppCalculator.calculateScore(itemAttribute, hiLoRule, forceFactorWeight);
//			double adjustedScore = 0.0; // need to calculate based upon algorithm
//			boolean isrecommended = score >= 2.5; // will be calulated based upon score and adjusted score
//			String recommended = null;
//			recommended = isrecommended ? "Y" : "N";
//			boolean override = false;
//			itemScoreDataValues = new ItemScoreDataValues(itemAttribute.getItemKey(), itemAttribute.getItemName(),
//					itemAttribute.getDepartment(), itemAttribute.getCategory(), itemAttribute.getSubCategory(),
//					itemAttribute.getItemClass(), itemAttribute.getPrice(), itemAttribute.getAbandonmentRate(), score,
//					adjustedScore, recommended, override);
//			itemScoreDataValuesList.add(itemScoreDataValues);
//		}
//		itemScoreDataValuesService.addItemScoreDataValues(itemScoreDataValuesList);
//	}

}
