package com.shop.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	private long id;

	private String username;

	private String password;

	private String lastName;

	private String email;

	private List<String> roles;

}
