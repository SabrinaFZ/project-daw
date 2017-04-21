package org.sabDav.service;

import org.sabDav.model.UserModel;

public interface UserService {
	
	public UserModel findUserByUsername(String username);
	
	public void saveUser(UserModel user);

}
