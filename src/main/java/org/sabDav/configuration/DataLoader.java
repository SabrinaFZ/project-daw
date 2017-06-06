package org.sabDav.configuration;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.sabDav.model.MovieModel;
import org.sabDav.model.UserModel;
import org.sabDav.repository.MovieRepository;
import org.sabDav.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@PostConstruct
	private void initDatabase() {
		
		if (userRepository.findByUsername("admin") == null) {
			GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority( "ROLE_USER"),
			new SimpleGrantedAuthority( "ROLE_ADMIN") };
			GrantedAuthority[] userRoles = { new SimpleGrantedAuthority( "ROLE_USER")};
			userRepository.save(new UserModel("admin", "admin", "admin@email.com", Arrays.asList(adminRoles)));
			userRepository.save(new UserModel("sabrina", "sabrina", "sabrina@email.com", Arrays.asList(userRoles)));
			userRepository.save(new UserModel("david", "david", "david@email.com", Arrays.asList(userRoles)));
			
			MovieModel movie1 = new MovieModel("Inception");
			movie1.setUrl_movie("https://www.youtube.com/embed/8hP9D6kZseM");
			movie1.setUrl_cover("http://www.impawards.com/2010/posters/inception_xlg.jpg");
			movie1.setDirector("Christopher Nolan");
			movie1.setYear(2010);
			movie1.setRating(8);
			MovieModel movie2 = new MovieModel("Avatar");		
			movie2.setUrl_movie("https://www.youtube.com/embed/tLylzuf1MWA");
			MovieModel movie3 = new MovieModel("The Dark Knight");
			movie3.setUrl_movie("https://www.youtube.com/embed/EXeTwQWrcwY");
			movieRepository.save(movie1);
			movieRepository.save(movie2);
			movieRepository.save(movie3);
		}// if repository not initialized
		
	}//initDatabase
		
}
