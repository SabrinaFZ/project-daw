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
		// User #2: "root", with password "p2" and roles "USER" and "ADMIN"
		GrantedAuthority[] adminRoles = { new SimpleGrantedAuthority( "ROLE_USER"),
		new SimpleGrantedAuthority( "ROLE_ADMIN") };
		GrantedAuthority[] userRoles = { new SimpleGrantedAuthority( "ROLE_USER")};
		userRepository.save(new UserModel("admin", "admin", "admin@email.com", Arrays.asList(adminRoles)));
		userRepository.save(new UserModel("sabrina", "sabrina", "sabrina@email.com", Arrays.asList(userRoles)));
		userRepository.save(new UserModel("david", "david", "david@email.com", Arrays.asList(userRoles)));
			
		/* TODO Lista inicial de peliculas */
		/*
				MovieModel movie1 = new MovieModel();
				movie1.setCast("Sam Worthington,  Zoe Saldana,  Sigourney Weaver,  Stephen Lang, Michelle Rodriguez,  Giovanni Ribisi,  Joel David Moore,  Wes Studi,  CCH Pounder, Laz Alonso,  Dileep Rao");
				movie1.setDescription("Año 2154. Jake Sully (Sam Worthington), un ex-marine condenado a vivir en una silla de ruedas, sigue siendo, a pesar de ello, un auténtico guerrero. Precisamente por ello ha sido designado para ir a Pandora, donde algunas empresas están extrayendo un mineral extraño que podría resolver la crisis energética de la Tierra. Para contrarrestar la toxicidad de la atmósfera de Pandora, se ha creado el programa Avatar, gracias al cual los seres humanos mantienen sus conciencias unidas a un avatar: un cuerpo biológico controlado de forma remota que puede sobrevivir en el aire letal. Esos cuerpos han sido creados con ADN humano, mezclado con ADN de los nativos de Pandora, los Na'vi. Convertido en avatar, Jake puede caminar otra vez. Su misión consiste en infiltrarse entre los Na'vi, que se han convertido en el mayor obstáculo para la extracción del mineral. Pero cuando Neytiri, una bella Na'vi (Zoe Saldana), salva la vida de Jake, todo cambia: Jake, tras superar ciertas pruebas, es admitido en su clan. Mientras tanto, los hombres esperan los resultados de la misión de Jake. (FILMAFFINITY)");
				movie1.setDirector("James Cameron");
				movie1.setName("Avatar");
				movie1.setRating(72);
				movie1.setUrl_cover("http://pics.filmaffinity.com/avatar-208925608-mmed.jpg");
				movie1.setUrl_movie("https://www.youtube.com/embed/tLylzuf1MWA");
				movie1.setYear(2009);
				
				MovieModel movie2 = new MovieModel();
				movie2.setCast("Leonardo DiCaprio,  Joseph Gordon-Levitt,  Ellen Page,  Ken Watanabe, Marion Cotillard,  Tom Hardy,  Cillian Murphy,  Tom Berenger,  Michael Caine, Dileep Rao,  Lukas Haas,  Pete Postlethwaite,  Talulah Riley,  Miranda Nolan");
				movie2.setDescription("Dom Cobb (DiCaprio) es un experto en el arte de apropiarse, durante el sueño, de los secretos del subconsciente ajeno. La extraña habilidad de Cobb le ha convertido en un hombre muy cotizado en el mundo del espionaje, pero también lo ha condenado a ser un fugitivo y, por consiguiente, a renunciar a llevar una vida normal. Su única oportunidad para cambiar de vida será hacer exactamente lo contrario de lo que ha hecho siempre: la incepción, que consiste en implantar una idea en el subconsciente en lugar de sustraerla. Sin embargo, su plan se complica debido a la intervención de alguien que parece predecir cada uno de sus movimientos, alguien a quien sólo Cobb podrá descubrir. (FILMAFFINITY)");
				movie2.setDirector("Christopher Nolan");
				movie2.setName("Origen");
				movie2.setRating(80);
				movie2.setUrl_cover("http://pics.filmaffinity.com/inception-652954101-mmed.jpg");
				movie2.setUrl_movie("https://www.youtube.com/embed/DuwC_hstWhw");
				movie2.setYear(2010);
				
				MovieModel movie3 = new MovieModel();
				movie3.setCast("Christian Bale,  Heath Ledger,  Aaron Eckhart,  Michael Caine,  Gary Oldman, Morgan Freeman,  Maggie Gyllenhaal,  Eric Roberts,  Cillian Murphy, Michael Jai White,  Chin Han,  William Fichtner,  Monique Gabriela Curnen, Nestor Carbonell,  Ritchie Coster,  Keith Szarabajka,  Colin McFarlane,  Joshua Harto, Melinda McGraw,  Ron Dean,  Nathan Gamble,  Tommy 'Tiny' Lister,  Michael Vieau");
				movie3.setDescription("Batman/Bruce Wayne (Christian Bale) regresa para continuar su guerra contra el crimen. Con la ayuda del teniente Jim Gordon (Gary Oldman) y del Fiscal del Distrito Harvey Dent (Aaron Eckhart), Batman se propone destruir el crimen organizado en la ciudad de Gotham. El triunvirato demuestra su eficacia, pero, de repente, aparece Joker (Heath Ledger), un nuevo criminal que desencadena el caos y tiene aterrados a los ciudadanos. (FILMAFFINITY)");
				movie3.setDirector("Christopher Nolan");
				movie3.setName("El caballero oscuro");
				movie3.setRating(81);
				movie3.setUrl_cover("http://pics.filmaffinity.com/the_dark_knight-102763119-mmed.jpg");
				movie3.setUrl_movie("https://www.youtube.com/embed/zrXP6TYK8rY");
				movie3.setYear(2008);
		*/
				MovieModel movie4 = new MovieModel("Origen");
				movie4.setCast("...");
				movie4.setDescription("...");
				movie4.setDirector("...");
//					movie4.setName("");
				movie4.setRating(0);
				movie4.setUrl_cover("http://pics.filmaffinity.com/inception-652954101-mmed.jpg");
				movie4.setUrl_movie("https://www.youtube.com/embed/DuwC_hstWhw");
				movie4.setYear(0);

				MovieModel movie5 = new MovieModel("Avatar");
				movie5.setCast("...");
				movie5.setDescription("...");
				movie5.setDirector("...");
//					movie5.setName("");
				movie5.setRating(0);
				movie5.setUrl_cover("http://pics.filmaffinity.com/avatar-208925608-mmed.jpg");
				movie5.setUrl_movie("https://www.youtube.com/embed/tLylzuf1MWA");
				movie5.setYear(0);
				
//					repository.save(movie1);
//					repository.save(movie2);
//					repository.save(movie3);
				movieRepository.save(movie4);
				movieRepository.save(movie5);
			}//initDatabase
		
}
