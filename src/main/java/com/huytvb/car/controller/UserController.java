package com.huytvb.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.huytvb.car.models.User;
import com.huytvb.car.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	public String goUser(Model model ) {
		model.addAttribute("users", userService.findAll());
		
		return "user";
	}

	@PostMapping("/user/addNewUser")
	public String addNewUser(User user) {
		userService.save(user);

		return "redirect:/user";
	}

	@RequestMapping("user/findById")
	@ResponseBody
	public User findById(Integer id)
	{
		return userService.findById(id);
	}

	@RequestMapping(value = "/user/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(User user) {
		userService.save(user);

		return "redirect:/user";
	}

	@RequestMapping(value = "/user/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(int id) {
		userService.delete(id);

		return "redirect:/user";
	}
	
	// Modified method to Add a new user User
	@PostMapping(value = "user/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);
		RedirectView redirectView = new RedirectView("/login", true);
		redir.addFlashAttribute("message", "You successfully registered! You can now login");
		return redirectView;
	}
}
