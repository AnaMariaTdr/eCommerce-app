package com.shop.service;

import com.shop.domain.User;
import com.shop.domain.model.response.UserDto;
import com.shop.exceptions.EmailExistsException;

public interface IUserService {
	
		User registerNewUserAccount(UserDto accountDto) throws EmailExistsException, EmailExistsException;
	}

