package com.shop.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.shop.domain.model.response.UserDto;

public class PasswordMatchesValiator implements ConstraintValidator<PasswordMatches, Object> {

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
	}

	@Override
	public boolean isValid(Object obj, ConstraintValidatorContext context) {
		UserDto user = (UserDto) obj;
		return user.getPassword().equals(user.getMatchingPassword());

	}

}
