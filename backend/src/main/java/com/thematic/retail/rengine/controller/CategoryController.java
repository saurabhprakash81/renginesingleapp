package com.thematic.retail.rengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thematic.retail.rengine.model.CategoryHierarchy;
import com.thematic.retail.rengine.service.CategoryHierarchyService;
import com.thematic.retail.rengine.util.CommonUtil;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {
	
	@Autowired
	private CategoryHierarchyService categoryHierarchyService;
	
	@GetMapping("/categoryhierarchy")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<CategoryHierarchy> getCategoryHierarchy(){
		System.out.println("I am getting category.... for USER : " + CommonUtil.getCurrentLoggedInUser());
		CategoryHierarchy categoryHierarchy = categoryHierarchyService.getCategoryHierarchy();
		if(categoryHierarchy !=null) {
			return ResponseEntity.ok(categoryHierarchy);
		} else {
			return (ResponseEntity<CategoryHierarchy>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/categoryhierarchy")
	public ResponseEntity<CategoryHierarchy> setCategorySelection(@RequestBody CategoryHierarchy categoryHierarchy) {
		CategoryHierarchy categoryHierarchy1 = categoryHierarchyService.setCategoryHierarchy(categoryHierarchy);
		if (categoryHierarchy1 != null) {
			return ResponseEntity.ok(categoryHierarchy1);
		} else {
			return (ResponseEntity<CategoryHierarchy>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}
	
}
