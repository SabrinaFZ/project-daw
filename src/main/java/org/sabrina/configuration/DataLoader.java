package org.sabrina.configuration;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.sabrina.model.UserModel;
import org.sabrina.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
	@Autowired
	private UserRepository userRepository;
	@PostConstruct
	private void initDatabase() {
		// User #2: "root", with password "p2" and roles "USER" and "ADMIN"
		GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority( "ROLE_USER"),
		new SimpleGrantedAuthority( "ROLE_ADMIN") };
		userRepository.save(new UserModel("admin", "admin", "admin@email.com", Arrays.asList(adminRoles)));
	}
}
