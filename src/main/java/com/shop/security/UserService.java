package com.shop.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.domain.User;
import com.shop.exceptions.EmailExistsException;
import com.shop.repository.UserRepository;
import com.shop.service.IUserService;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository repository;

	@Transactional
	@Override
	public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {

		if (emailExist(accountDto.getEmail())) {
			throw new EmailExistsException("There is an account with that email adress: " + accountDto.getEmail());
		}
		return null;// modifica ! 

		// the rest of the registration operation
	}

	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}
