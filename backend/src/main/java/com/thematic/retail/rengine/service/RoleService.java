package com.thematic.retail.rengine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thematic.retail.rengine.entity.Role;
import com.thematic.retail.rengine.repository.IRoleRepository;

@Service
public class RoleService {

	@Autowired
	private IRoleRepository roleRepo;

	public void addRoles(List<Role> roles) {
		for (Role role : roles) {
			roleRepo.save(role);
		}
	}

	public void addRole(Role role) {
		roleRepo.save(role);
	}

}
