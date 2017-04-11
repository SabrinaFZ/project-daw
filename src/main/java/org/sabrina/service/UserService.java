package org.sabrina.service;

import org.sabrina.model.UserModel;

public interface UserService {
	
	public UserModel findUserByEmail(String email);
	public void saveUser(UserModel user);

}
