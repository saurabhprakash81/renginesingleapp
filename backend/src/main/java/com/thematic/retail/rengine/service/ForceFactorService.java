package com.thematic.retail.rengine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.thematic.retail.rengine.entity.ForceFactorsValues;
import com.thematic.retail.rengine.entity.ItemAttributes;
import com.thematic.retail.rengine.entity.ItemAttributesHiLoRule;
import com.thematic.retail.rengine.entity.ItemScoreDataValues;
import com.thematic.retail.rengine.entity.User;
import com.thematic.retail.rengine.model.ForceFactorWeight;
import com.thematic.retail.rengine.model.ForceFactors;
import com.thematic.retail.rengine.model.NForceFactors;
import com.thematic.retail.rengine.repository.IUserRepository;
import com.thematic.retail.rengine.util.AppCalculator;
import com.thematic.retail.rengine.util.CommonUtil;

@Service
public class ForceFactorService {

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ItemAttributeService itemAttributeService;

	@Autowired
	private ItemAttributeHiLoRuleService itemAttributeHiLoRuleService;

	@Autowired
	private ItemScoreDataValuesService itemScoreDataValuesService;

	public ForceFactors getForceFactors() {
		String currentLoggedInUser = CommonUtil.getCurrentLoggedInUser();
		if (currentLoggedInUser != null) {
			//UserDetails userDetails = userDetailsService.loadUserByUsername(CommonUtil.getCurrentLoggedInUser());
			UserDetails userDetails = userDetailsService.loadUserByUsername(currentLoggedInUser);
			User user = userRepository.getUserByUsername(userDetails.getUsername());
			ForceFactorsValues forceFactorsValues = user.getForceFactorValues();
			return new Gson().fromJson(forceFactorsValues.getValue(), ForceFactors.class);
		} else {
			return CommonUtil.getForceFactors();
		}
	}

	public NForceFactors[] getNForceFactors() {
		String currentLoggedInUser = CommonUtil.getCurrentLoggedInUser();
		if (currentLoggedInUser != null) {
			UserDetails userDetails = userDetailsService.loadUserByUsername(CommonUtil.getCurrentLoggedInUser());
			User user = userRepository.getUserByUsername(userDetails.getUsername());
			ForceFactorsValues forceFactorsValues = user.getNForceFactorValues();
			return new Gson().fromJson(forceFactorsValues.getValue(), NForceFactors[].class);
		} else {
			return CommonUtil.getNForceFactors();
		}

	}

	public ForceFactorWeight getForceFactorWeight() {
		return CommonUtil.getForceFactorWeight(getForceFactors());
	}

	public ForceFactorWeight getNForceFactorWeight() {
		return CommonUtil.getForceFactorWeight(getNForceFactors());
	}

	public ForceFactors setForceFactors(ForceFactors forceFactors) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(CommonUtil.getCurrentLoggedInUser());
		User user = userRepository.getUserByUsername(userDetails.getUsername());
		String newValue = CommonUtil.getJsonStringFromForceFactors(forceFactors);
		user.getForceFactorValues().setValue(newValue);
		userRepository.save(user);
		return forceFactors;
	}

	public NForceFactors[] setForceFactors(NForceFactors[] forceFactors) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(CommonUtil.getCurrentLoggedInUser());
		User user = userRepository.getUserByUsername(userDetails.getUsername());
		String newValue = CommonUtil.getJsonStringFromNForceFactors(forceFactors);
		user.getNForceFactorValues().setValue(newValue);
		userRepository.save(user);
		return forceFactors;
	}

	public void runRECalculation() {
//		private List<ItemScore> runOnTestData() {
//		
		List<ItemScoreDataValues> itemScoreDataValuesList = new ArrayList<ItemScoreDataValues>();
		List<ItemAttributes> itemAttributesList = itemAttributeService.getAllItemAttributes();
		List<ItemAttributesHiLoRule> itemAttributesHiLoList = itemAttributeHiLoRuleService
				.getAllItemAttributeHiLoRule();
		//ForceFactorWeight forceFactorWeight = new ForceFactorWeight(5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 10, 20, 5, 5, 5);
		//ForceFactorWeight forceFactorWeight = getForceFactorWeight();
		ForceFactorWeight forceFactorWeight = getNForceFactorWeight();
		// System.out.println(forceFactorWeight.toString());
		ItemAttributes itemAttribute;
		ItemAttributesHiLoRule hiLoRule;
		ItemScoreDataValues itemScoreDataValues;
		for (int i = 0; i < itemAttributesList.size(); i++) {
			itemAttribute = itemAttributesList.get(i);
			hiLoRule = itemAttributesHiLoList.get(i);
			double score = AppCalculator.calculateScore(itemAttribute, hiLoRule, forceFactorWeight);
			double adjustedScore = 0.0; // need to calculate based upon algorithm
			boolean isrecommended = score >= 2.5; // will be calulated based upon score and adjusted score
			String recommended = null;
			recommended = isrecommended ? "Y" : "N";
			boolean override = false;
			itemScoreDataValues = new ItemScoreDataValues(itemAttribute.getItemKey(), itemAttribute.getItemName(),
					itemAttribute.getDepartment(), itemAttribute.getCategory(), itemAttribute.getSubCategory(),
					itemAttribute.getItemClass(), itemAttribute.getPrice(), itemAttribute.getAbandonmentRate(), score,
					adjustedScore, recommended, override);
			itemScoreDataValuesList.add(itemScoreDataValues);
		}
		itemScoreDataValuesService.addItemScoreDataValues(itemScoreDataValuesList);
		
	}

}
