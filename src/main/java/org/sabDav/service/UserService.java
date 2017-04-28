package org.sabDav.service;

import org.sabDav.model.UserModel;
import org.sabDav.repository.UserRepository;

public interface UserService {
	
	public UserModel findUserByUsername(String username);
	
	public void saveUser(UserModel user);

	public UserRepository getUserRepository();

}
