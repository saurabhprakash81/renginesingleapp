package com.thematic.retail.rengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thematic.retail.rengine.entity.Role;

@Repository
public interface IRoleRepository  extends CrudRepository<Role, Integer> {


}
