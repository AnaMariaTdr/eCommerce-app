package com.shop.service;

import com.shop.domain.User;
import com.shop.exceptions.EmailExistsException;
import com.shop.security.UserDto;

public interface IUserService {
	
		User registerNewUserAccount(UserDto accountDto) throws EmailExistsException, EmailExistsException;
	}

