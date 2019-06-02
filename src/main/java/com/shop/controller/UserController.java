package com.shop.controller;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.shop.domain.User;
import com.shop.domain.service;
import com.shop.exceptions.EmailExistsException;
import com.shop.security.UserDto;

public class UserController {

	@RequestMapping(value = "/user/registration", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto userDto = new UserDto(); // Alt+Shift+R refactor name everywhere
		model.addAttribute("user", userDto);
		return "registration";
	}

	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDto accountDto, BindingResult result,
			WebRequest request, Errors errors) throws EmailExistsException {

		User registered = new User();
		if (!result.hasErrors()) {
			registered = createUserAccount(accountDto, result);
		}
		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}
		if (result.hasErrors()) {
			return new ModelAndView("registration", "user", accountDto);
		} else {
			return new ModelAndView("successRegister", "user", accountDto);
		}
	}

	private User createUserAccount(UserDto accountDto, BindingResult result) throws EmailExistsException {
		User registered = null;
		registered = service.registerNewUserAccount(accountDto);
		return registered;
	}


}
