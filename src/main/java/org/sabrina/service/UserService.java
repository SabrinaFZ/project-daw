package org.sabrina.service;

import org.sabrina.model.UserModel;

public interface UserService {
	
	public UserModel findUserByUsername(String username);
	
	public void saveUser(UserModel user);

}
