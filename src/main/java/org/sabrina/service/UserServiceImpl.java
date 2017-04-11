package org.sabrina.service;

import java.util.*;

import org.sabrina.model.*;
import org.sabrina.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserModel findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(UserModel user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setStatus(1);
		RolModel userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<RolModel>(Arrays.asList(userRole)));
		userRepository.save(user);		
	}

}
