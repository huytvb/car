package com.huytvb.car.security.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huytvb.car.models.User;
import com.huytvb.car.security.models.Role;
import com.huytvb.car.security.services.RoleService;
import com.huytvb.car.services.UserService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@GetMapping("/security/user/Edit/{id}")
	public String editUser(@PathVariable Integer id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		model.addAttribute("userRoles", roleService.getUserRoles(user));
		model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
		return "editRole";
	}

	@GetMapping("/role")
	public String goRole(Model model) {
		List<Role> roleList = roleService.findAll();
		model.addAttribute("roles", roleList);

		return "role";
	}

	@PostMapping("/role/addNew")
	public String addNew(Role role) {
		roleService.save(role);

		return "redirect:/role";
	}

	@RequestMapping("role/findById")
	@ResponseBody
	public Optional<Role> findById(int id) {

		return roleService.findById(id);
	}

	@RequestMapping(value = "/role/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Role role) {
		roleService.save(role);

		return "redirect:/role";
	}

	@RequestMapping(value = "/role/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		roleService.delete(id);

		return "redirect:/role";
	}

	@RequestMapping("/security/role/assign/{userId}/{roleId}")
	public String assignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
		roleService.assignUserRole(userId, roleId);
		return "redirect:/security/user/Edit/" + userId;
	}

	@RequestMapping("/security/role/unassign/{userId}/{roleId}")
	public String unassignRole(@PathVariable Integer userId, @PathVariable Integer roleId) {
		roleService.unassignUserRole(userId, roleId);
		return "redirect:/security/user/Edit/" + userId;
	}
}
