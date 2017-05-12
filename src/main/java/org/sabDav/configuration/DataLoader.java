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
		
		GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority( "ROLE_USER"),
		new SimpleGrantedAuthority( "ROLE_ADMIN") };
		GrantedAuthority[] userRoles = { new SimpleGrantedAuthority( "ROLE_USER")};
		userRepository.save(new UserModel("admin", "admin", "admin@email.com", Arrays.asList(adminRoles)));
		userRepository.save(new UserModel("sabrina", "sabrina", "sabrina@email.com", Arrays.asList(userRoles)));
		userRepository.save(new UserModel("david", "david", "david@email.com", Arrays.asList(userRoles)));
		
		MovieModel movie1 = new MovieModel("Inception");
		movie1.setUrl_movie("https://www.youtube.com/embed/8hP9D6kZseM");
		movie1.setUrl_cover("http://pics.filmaffinity.com/inception-652954101-mmed.jpg");
		movie1.setDirector("Christopher Nolan");
		movie1.setYear(2010);
		movie1.setRating(8);
		MovieModel movie2 = new MovieModel("Avatar");		
		movie2.setUrl_movie("https://www.youtube.com/embed/tLylzuf1MWA");
		movie2.setUrl_cover("http://pics.filmaffinity.com/avatar-208925608-mmed.jpg");
		movie2.setDirector("James Cameron");
		movie2.setYear(2009);
		movie2.setRating(7);
		MovieModel movie3 = new MovieModel("The Dark Knight");
		movie3.setUrl_movie("https://www.youtube.com/embed/EXeTwQWrcwY");
		movie3.setUrl_cover("http://pics.filmaffinity.com/the_dark_knight-102763119-mmed.jpg");
		movie3.setDirector("Christopher Nolan");
		movie3.setYear(2008);
		movie3.setRating(8);
		movieRepository.save(movie1);
		movieRepository.save(movie2);
		movieRepository.save(movie3);
		
		}//initDatabase
		
}
