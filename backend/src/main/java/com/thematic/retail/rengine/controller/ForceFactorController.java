package com.thematic.retail.rengine.controller;

import com.thematic.retail.rengine.model.NForceFactors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thematic.retail.rengine.model.ForceFactors;
import com.thematic.retail.rengine.service.ForceFactorService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ForceFactorController {

	@Autowired
	private ForceFactorService forceFactorService;
	
	@GetMapping("/forcefactor")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<ForceFactors> getForceFactors() {
		System.out.println("I am in get forcefactor controller....");
		ForceFactors forceFactors = forceFactorService.getForceFactors();
		if (forceFactors != null) {
			return ResponseEntity.ok(forceFactors);
		} else {
			return (ResponseEntity<ForceFactors>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/nforcefactor")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<NForceFactors[]> getNForceFactors() {
		System.out.println("I am in get forcefactor controller....");
		NForceFactors[] forceFactors = forceFactorService.getNForceFactors();
		if (forceFactors != null) {
			return ResponseEntity.ok(forceFactors);
		} else {
			return (ResponseEntity<NForceFactors[]>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/forcefactor")
	public ResponseEntity<ForceFactors> setForceFactors(@RequestBody ForceFactors forceFactors) {
		System.out.println("I am in post forcefactor controller....");
		ForceFactors forceFactors1 = forceFactorService.setForceFactors(forceFactors);
		if (forceFactors1 != null) {
			return ResponseEntity.ok(forceFactors1);
		} else {
			return (ResponseEntity<ForceFactors>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/nforcefactor")
	public ResponseEntity<NForceFactors[]> setForceFactors(@RequestBody NForceFactors[] forceFactors) {
		System.out.println("I am in post forcefactor controller....");
		NForceFactors[] forceFactors1 = forceFactorService.setForceFactors(forceFactors);
		if (forceFactors1 != null) {
			return ResponseEntity.ok(forceFactors1);
		} else {
			return (ResponseEntity<NForceFactors[]>) ResponseEntity.status(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/calculate")
	public void runCalcualtionOnData() {
		forceFactorService.runRECalculation();
	}
}
