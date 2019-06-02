package com.shop.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.domain.User;
import com.shop.exceptions.EmailExistsException;
import com.shop.repository.UserRepository;
import com.shop.security.UserDto;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository repository;

	@Transactional
	    @Override
	    public User registerNewUserAccount(UserDto accountDto) 
	      throws EmailExistsException {
	         
	        if (emailExists(accountDto.getEmail())) {   
	            throw new EmailExistsException(
	              "There is an account with that email address:"  + accountDto.getEmail());
	        }
	        User user = new User();    
	        user.setUsername(accountDto.getFirstName());
	        user.setLastName(accountDto.getLastName());
	        user.setPassword(accountDto.getPassword());
	        user.setEmail(accountDto.getEmail());
	        user.setRoles(Arrays.asList("ROLE_USER"));
	        return repository.save(user);       
	    }

	private boolean emailExists(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}
