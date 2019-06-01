package com.shop.security;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class userDTO {
	@NotNull
	@NotEmpty
	private String firstName;

	@NotNull
	@NotEmpty
	private String lastName;
	
	@PasswordMatches
	@NotNull
	@NotEmpty
	private String password;
	private String matchingPassword;

	@ValidEmail
	@NotNull
	@NotEmpty
	private String email;

}
