package com.huytvb.car.security.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytvb.car.models.User;
import com.huytvb.car.repositories.UserRepository;
import com.huytvb.car.security.models.Role;
import com.huytvb.car.security.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;

	// Get All Roles
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	// Get Role By Id
	public Optional<Role> findById(int id) {
		return roleRepository.findById(id);
	}

	// Delete Role
	public void delete(int id) {
		roleRepository.deleteById(id);
	}

	// Update Role
	public void save(Role role) {
		roleRepository.save(role);
	}
	
	//Gán Role vào User
	public void assignUserRole(Integer userId, Integer roleId) {
		User user = userRepository.findById(userId).orElse(null);
		Role role = roleRepository.findById(roleId).orElse(null);
		
		Set<Role> userRoles = user.getRoles();
		userRoles.add(role);
		user.setRoles(userRoles);
		
		userRepository.save(user);
	}

	//Gỡ Role khỏi User
	public void unassignUserRole(Integer userId, Integer roleId) {
		User user = userRepository.findById(userId).orElse(null);
		Set<Role> userRoles = user.getRoles();
		
		userRoles.removeIf(x -> x.getId() == roleId);
		userRepository.save(user);
	}
	
	public Set<Role> getUserRoles(User user) {
		return user.getRoles();
	}
	
	public Set<Role> getUserNotRoles(User user) {
		return roleRepository.getUserNotRoles(user.getId());
	}
}
