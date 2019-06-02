package com.shop.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.shop.security.userDTO;

public class UserController {
	
	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
	    userDTO userDto = new userDTO();
	    model.addAttribute("user", userDto);
	    return "registration";
	}

}
