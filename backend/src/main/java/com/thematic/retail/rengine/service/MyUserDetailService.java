package com.thematic.retail.rengine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thematic.retail.rengine.entity.User;
import com.thematic.retail.rengine.model.MyUserDetails;
import com.thematic.retail.rengine.repository.IUserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}

		return new MyUserDetails(user);
	}

	public void addUsers(List<User> users) {
		for (User user : users) {
			userRepository.save(user);
		}
	}

	public void addUser(User user) {
		userRepository.save(user);
	}
}
