package com.thematic.retail.rengine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.thematic.retail.rengine.entity.CategorySelectionValues;
import com.thematic.retail.rengine.entity.ForceFactorsValues;
import com.thematic.retail.rengine.entity.User;
import com.thematic.retail.rengine.model.CategoryHierarchy;
import com.thematic.retail.rengine.model.CategorySelection;
import com.thematic.retail.rengine.model.ForceFactors;
import com.thematic.retail.rengine.repository.IUserRepository;
import com.thematic.retail.rengine.util.CommonUtil;

@Service
public class CategoryHierarchyService {

	@Autowired
	private MyUserDetailService userDetailsService;
	
	@Autowired
	private IUserRepository userRepository;

	public CategoryHierarchy getCategoryHierarchy() {
		UserDetails userDetails = userDetailsService.loadUserByUsername(CommonUtil.getCurrentLoggedInUser());
		User user = userRepository.getUserByUsername(userDetails.getUsername());
		CategorySelectionValues categorySelectionValues = user.getCateoryselectionValues();
		return new Gson().fromJson(categorySelectionValues.getValue(), CategoryHierarchy.class);
	}

	public CategoryHierarchy setCategoryHierarchy(CategoryHierarchy categoryHierarchy) {
			System.out.println("CategoryHierarchy : setting in user profile...");
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(CommonUtil.getCurrentLoggedInUser());
			User user = userRepository.getUserByUsername(userDetails.getUsername());
			
			String newValue = CommonUtil.getJsonStringFromCategoryHierarchy(categoryHierarchy);
			
			user.getCateoryselectionValues().setValue(newValue);
			System.out.println("new Value : " + newValue);
			System.out.println("User : " + user);
			
			userRepository.save(user);			
			return categoryHierarchy;
	}
}