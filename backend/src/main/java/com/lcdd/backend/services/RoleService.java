package com.lcdd.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.RoleRepository;
import com.lcdd.backend.pojo.Role;
import com.lcdd.backend.pojo.User;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	
	public Role findOne(long id) {
		return roleRepo.findById(id);
	}
	
	public Role findByName(String name) {
		return roleRepo.findByName(name);
	}
	
	public List<Role> findAll() {
		return roleRepo.findAll();
	}
	
	public List<User> getUsersByRoleName(String nameRole){
		Role role = roleRepo.findByName(nameRole);
		return role.getUsers();
	}
}
