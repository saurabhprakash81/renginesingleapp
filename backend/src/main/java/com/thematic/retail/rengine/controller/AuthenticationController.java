package com.thematic.retail.rengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thematic.retail.rengine.model.AuthRequest;
import com.thematic.retail.rengine.model.AuthResponse;
import com.thematic.retail.rengine.model.UserInfo;
import com.thematic.retail.rengine.service.MyUserDetailService;
import com.thematic.retail.rengine.util.CommonUtil;
import com.thematic.retail.rengine.util.JwtTokenUtil;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private MyUserDetailService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {

		System.out.println("I am in controller....");
		try {
			authenticate(authRequest.getUsername(), authRequest.getUserpassword());
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		//System.out.println("Role = " + userDetails.getAuthorities());
		UserInfo userInfo = new UserInfo(userDetails.getUsername(), userDetails.getAuthorities().toString());
		AuthResponse authResponse = new AuthResponse(token, userInfo);

		return ResponseEntity.ok(authResponse);

	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<AuthResponse> user() {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(CommonUtil.getCurrentLoggedInUser());
		UserInfo userInfo = new UserInfo(userDetails.getUsername(), userDetails.getAuthorities().toString());
		AuthResponse authResponse = new AuthResponse("Authentiacaion successfull....", userInfo);
		return ResponseEntity.ok(authResponse);

	}

}
