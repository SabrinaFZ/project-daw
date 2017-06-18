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
				
				//Inception
				MovieModel movie1 = new MovieModel("Inception");
				movie1.setUrl_movie("https://www.youtube.com/embed/8hP9D6kZseM");
				movie1.setDirector("Christopher Nolan");
				movie1.setYear(2010);
				movie1.setRating(8);
				movieRepository.save(movie1);
				
				//Avatar
				MovieModel movie2 = new MovieModel("Avatar");		
				movie2.setUrl_movie("https://www.youtube.com/embed/tLylzuf1MWA");
				movie2.setDirector("James Cameron");
				movie2.setYear(2009);
				movie2.setRating(7);
				movieRepository.save(movie2);
				
				//The Dark Knight
				MovieModel movie3 = new MovieModel("The Dark Knight");
				movie3.setUrl_movie("https://www.youtube.com/embed/EXeTwQWrcwY");
				movie3.setDirector("Christopher Nolan");
				movie3.setYear(2008);
				movie3.setRating(8);
				movieRepository.save(movie3);
				
				//Captain America: Civil War
				MovieModel movie4 = new MovieModel("Captain America: Civil War");
				movie4.setUrl_movie("https://www.youtube.com/embed/43NWzay3W4s");
				movie4.setDirector("Anthony Russo, Joe Russo");
				movie4.setYear(2016);
				movie4.setRating(6);
				movieRepository.save(movie4);
				
				//Rogue One: A Star Wars Story
				MovieModel movie5 = new MovieModel("Rogue One: A Star Wars Story");
				movie5.setUrl_movie("");
				movie5.setDirector("Gareth Edwards");
				movie5.setYear(2016);
				movie5.setRating(7);
				movieRepository.save(movie5);
				
				//Finding Dory
				MovieModel movie6 = new MovieModel("Finding Dory");
				movie6.setUrl_movie("https://www.youtube.com/embed/MKJA-VLpiCo");
				movie6.setDirector("Andrew Stanton,  Angus MacLane");
				movie6.setYear(2016);
				movie6.setRating(6);
				movieRepository.save(movie6);
				
				//Zootopia
				MovieModel movie7 = new MovieModel("Zootopia");
				movie7.setUrl_movie("https://www.youtube.com/embed/bY73vFGhSVk");
				movie7.setDirector("Byron Howard,  Rich Moore,  Jared Bush");
				movie7.setYear(2016);
				movie7.setRating(7);
				movieRepository.save(movie7);
				
				//The Jungle Book
				MovieModel movie8 = new MovieModel("The Jungle Book");
				movie8.setUrl_movie("https://www.youtube.com/embed/C4qgAaxB_pc");
				movie8.setDirector("Jon Favreau");
				movie8.setYear(2016);
				movie8.setRating(6);
				movieRepository.save(movie8);
				
				//The Secret Life of Pets
				MovieModel movie9 = new MovieModel("The Secret Life of Pets");
				movie9.setUrl_movie("https://www.youtube.com/embed/i-80SGWfEjM");
				movie9.setDirector("Chris Renaud,  Yarrow Cheney");
				movie9.setYear(2016);
				movie9.setRating(5);
				movieRepository.save(movie9);
				
				//Batman v. Superman: Dawn of Justice
				MovieModel movie10 = new MovieModel("Batman v. Superman: Dawn of Justice");
				movie10.setUrl_movie("https://www.youtube.com/embed/Cle_rKBpZ28");
				movie10.setDirector("Zack Snyder");
				movie10.setYear(2016);
				movie10.setRating(5);
				movieRepository.save(movie10);
				
				//Fantastic Beasts and Where to Find Them
				MovieModel movie11 = new MovieModel("Fantastic Beasts and Where to Find Them");
				movie11.setUrl_movie("https://www.youtube.com/embed/Wj1devH5JP4");
				movie11.setDirector("David Yates");
				movie11.setYear(2016);
				movie11.setRating(6);
				movieRepository.save(movie11);
				
				//Deadpool
				MovieModel movie12 = new MovieModel("Deadpool");
				movie12.setUrl_movie("https://www.youtube.com/embed/ONHBaC-pfsk");
				movie12.setDirector("Tim Miller");
				movie12.setYear(2016);
				movie12.setRating(6);
				movieRepository.save(movie12);
				
				//Suicide Squad
				MovieModel movie13 = new MovieModel("Suicide Squad");
				movie13.setUrl_movie("https://www.youtube.com/embed/CmRih_VtVAs");
				movie13.setDirector("David Ayer");
				movie13.setYear(2016);
				movie13.setRating(5);
				movieRepository.save(movie13);
				
				//Star Wars: The Force Awakens
				MovieModel movie14 = new MovieModel("Star Wars: The Force Awakens");
				movie14.setUrl_movie("https://www.youtube.com/embed/sGbxmsDFVnE");
				movie14.setDirector("J.J. Abrams");
				movie14.setYear(2015);
				movie14.setRating(6);
				movieRepository.save(movie14);
				
				//Jurassic World
				MovieModel movie15 = new MovieModel("Jurassic World");
				movie15.setUrl_movie("https://www.youtube.com/embed/aJJrkyHas78");
				movie15.setDirector("Colin Trevorrow");
				movie15.setYear(2015);
				movie15.setRating(5);
				movieRepository.save(movie15);
				
				//Fast & Furious 7
				MovieModel movie16 = new MovieModel("Fast & Furious 7");
				movie16.setUrl_movie("https://www.youtube.com/embed/5Yab0sXGEjg");
				movie16.setDirector("James Wan");
				movie16.setYear(2015);
				movie16.setRating(5);
				movieRepository.save(movie16);
				
				//Avengers: Age of Ultron
				MovieModel movie17 = new MovieModel("Avengers: Age of Ultron");
				movie17.setUrl_movie("https://www.youtube.com/embed/tmeOjFno6Do");
				movie17.setDirector("Joss Whedon");
				movie17.setYear(2015);
				movie17.setRating(6);
				movieRepository.save(movie17);
				
				//Minions
				MovieModel movie18 = new MovieModel("Minions");
				movie18.setUrl_movie("https://www.youtube.com/embed/P9-FCC6I7u0");
				movie18.setDirector("Kyle Balda,  Pierre Coffin");
				movie18.setYear(2015);
				movie18.setRating(5);
				movieRepository.save(movie18);
				
				//Spectre
				MovieModel movie19 = new MovieModel("Spectre");
				movie19.setUrl_movie("https://www.youtube.com/embed/LTDaET-JweU");
				movie19.setDirector("Sam Mendes");
				movie19.setYear(2015);
				movie19.setRating(6);
				movieRepository.save(movie19);
				
				//Inside Out
				MovieModel movie20 = new MovieModel("Inside Out");
				movie20.setUrl_movie("https://www.youtube.com/embed/_MC3XuMvsDI");
				movie20.setDirector("Pete Docter,  Ronnie Del Carmen");
				movie20.setYear(2015);
				movie20.setRating(7);
				movieRepository.save(movie20);
				
				//Mission: Impossible – Rogue Nation
				MovieModel movie21 = new MovieModel("Mission: Impossible – Rogue Nation");
				movie21.setUrl_movie("https://www.youtube.com/embed/gOW_azQbOjw");
				movie21.setDirector("Christopher McQuarrie");
				movie21.setYear(2015);
				movie21.setRating(6);
				movieRepository.save(movie21);
				
				//The Hunger Games: Mockingjay – Part 2
				MovieModel movie22 = new MovieModel("The Hunger Games: Mockingjay – Part 2");
				movie22.setUrl_movie("https://www.youtube.com/embed/n-7K_OjsDCQ");
				movie22.setDirector("Francis Lawrence");
				movie22.setYear(2015);
				movie22.setRating(5);
				movieRepository.save(movie22);
				
				//The Martian
				MovieModel movie23 = new MovieModel("The Martian");
				movie23.setUrl_movie("https://www.youtube.com/embed/QNZRR4qzL1Q");
				movie23.setDirector("Ridley Scott");
				movie23.setYear(2015);
				movie23.setRating(7);
				movieRepository.save(movie23);
				
				//Transformers: Age of Extinction
				MovieModel movie24 = new MovieModel("Transformers: Age of Extinction");
				movie24.setUrl_movie("https://www.youtube.com/embed/ubGpDoyJvmI");
				movie24.setDirector("Michael Bay");
				movie24.setYear(2014);
				movie24.setRating(4);
				movieRepository.save(movie24);
				
				//The Hobbit: The Battle of the Five Armies
				MovieModel movie25 = new MovieModel("The Hobbit: The Battle of the Five Armies");
				movie25.setUrl_movie("https://www.youtube.com/embed/iVAgTiBrrDA");
				movie25.setDirector("Peter Jackson");
				movie25.setYear(2015);
				movie25.setRating(6);
				movieRepository.save(movie25);
				
				//Maleficent
				MovieModel movie26 = new MovieModel("Maleficent");
				movie26.setUrl_movie("https://www.youtube.com/embed/704EXbJ-b5k");
				movie26.setDirector("Robert Stromberg");
				movie26.setYear(2015);
				movie26.setRating(6);
				movieRepository.save(movie26);
				
				//The Hunger Games: Mockingjay – Part 1
				MovieModel movie27 = new MovieModel("The Hunger Games: Mockingjay – Part 1");
				movie27.setUrl_movie("https://www.youtube.com/embed/C_Tsj_wTJkQ");
				movie27.setDirector("Francis Lawrence");
				movie27.setYear(2015);
				movie27.setRating(5);
				movieRepository.save(movie27);
				
				//Frozen
				MovieModel movie28 = new MovieModel("Frozen");
				movie28.setUrl_movie("https://www.youtube.com/embed/d_qR8YR6WeU");
				movie28.setDirector("Chris Buck,  Jennifer Lee");
				movie28.setYear(2013);
				movie28.setRating(6);
				movieRepository.save(movie28);
				
				//Iron Man 3
				MovieModel movie29 = new MovieModel("Iron Man 3");
				movie29.setUrl_movie("https://www.youtube.com/embed/0zglvT1q-Wk");
				movie29.setDirector("Shane Black");
				movie29.setYear(2013);
				movie29.setRating(6);
				movieRepository.save(movie29);
				
				//Despicable Me 2
				MovieModel movie30 = new MovieModel("Despicable Me 2");
				movie30.setUrl_movie("https://www.youtube.com/embed/TlbnGSMJQbQ");
				movie30.setDirector("Pierre Coffin,  Chris Renaud");
				movie30.setYear(2013);
				movie30.setRating(6);
				movieRepository.save(movie30);
				
				//The Hobbit: The Desolation of Smaug
				MovieModel movie31 = new MovieModel("The Hobbit: The Desolation of Smaug");
				movie31.setUrl_movie("https://www.youtube.com/embed/lfflhfn1W-o");
				movie31.setDirector("Peter Jackson");
				movie31.setYear(2013);
				movie31.setRating(6);
				movieRepository.save(movie31);
				
				//The Hunger Games: Catching Fire
				MovieModel movie32 = new MovieModel("The Hunger Games: Catching Fire");
				movie32.setUrl_movie("https://www.youtube.com/embed/zoKj7TdJk98");
				movie32.setDirector("Francis Lawrence");
				movie32.setYear(2013);
				movie32.setRating(6);
				movieRepository.save(movie32);
				
				//The Avengers
				MovieModel movie33 = new MovieModel("The Avengers");
				movie33.setUrl_movie("https://www.youtube.com/embed/1hPpG4s3-O4");
				movie33.setDirector("Joss Whedon");
				movie33.setYear(2012);
				movie33.setRating(6);
				movieRepository.save(movie33);
				
				//Skyfall
				MovieModel movie34 = new MovieModel("Skyfall");
				movie34.setUrl_movie("https://www.youtube.com/embed/YFNv5nDYMsU");
				movie34.setDirector("Sam Mendes");
				movie34.setYear(2012);
				movie34.setRating(6);
				movieRepository.save(movie34);
				
				//The Dark Knight Rises
				MovieModel movie35 = new MovieModel("The Dark Knight Rises");
				movie35.setUrl_movie("https://www.youtube.com/embed/RkBsJ7m7NF8");
				movie35.setDirector("Christopher Nolan");
				movie35.setYear(2012);
				movie35.setRating(7);
				movieRepository.save(movie35);
				
				//The Hobbit: An Unexpected Journey
				MovieModel movie36 = new MovieModel("The Hobbit: An Unexpected Journey");
				movie36.setUrl_movie("https://www.youtube.com/embed/lFH2QjSsdGQ");
				movie36.setDirector("Peter Jackson");
				movie36.setYear(2012);
				movie36.setRating(7);
				movieRepository.save(movie36);
				
				//Ice Age: Continental Drift
				MovieModel movie37 = new MovieModel("Ice Age: Continental Drift");
				movie37.setUrl_movie("https://www.youtube.com/embed/hzixp8s4pyg");
				movie37.setDirector("Steve Martino,  Mike Thurmeier");
				movie37.setYear(2012);
				movie37.setRating(5);
				movieRepository.save(movie37);
				
				//Harry Potter and the Deathly Hallows – Part 2
				MovieModel movie38 = new MovieModel("Harry Potter and the Deathly Hallows – Part 2");
				movie38.setUrl_movie("https://www.youtube.com/embed/PUXpgitNeOU");
				movie38.setDirector("David Yates");
				movie38.setYear(2011);
				movie38.setRating(7);
				movieRepository.save(movie38);
				
				//Transformers: Dark of the Moon
				MovieModel movie39 = new MovieModel("Transformers: Dark of the Moon");
				movie39.setUrl_movie("https://www.youtube.com/embed/kHRf01Gjosk");
				movie39.setDirector("Michael Bay");
				movie39.setYear(2011);
				movie39.setRating(5);
				movieRepository.save(movie39);
				
				//Pirates of the Caribbean: On Stranger Tides
				MovieModel movie40 = new MovieModel("Pirates of the Caribbean: On Stranger Tides");
				movie40.setUrl_movie("https://www.youtube.com/embed/KR_9A-cUEJc");
				movie40.setDirector("Rob Marshall");
				movie40.setYear(2011);
				movie40.setRating(5);
				movieRepository.save(movie40);
				
				//The Twilight Saga: Breaking Dawn – Part 1
				MovieModel movie41 = new MovieModel("The Twilight Saga: Breaking Dawn – Part 1");
				movie41.setUrl_movie("https://www.youtube.com/embed/PQNLfo-SOR4");
				movie41.setDirector("Bill Condon");
				movie41.setYear(2011);
				movie41.setRating(4);
				movieRepository.save(movie41);
				
				//Mission: Impossible – Ghost Protocol
				MovieModel movie42 = new MovieModel("Mission: Impossible – Ghost Protocol");
				movie42.setUrl_movie("https://www.youtube.com/embed/ceXlmGay1LA");
				movie42.setDirector("Brad Bird");
				movie42.setYear(2011);
				movie42.setRating(6);
				movieRepository.save(movie42);
				
				//Toy Story 3
				MovieModel movie43 = new MovieModel("Toy Story 3");
				movie43.setUrl_movie("https://www.youtube.com/embed/dxUQlgRR-v4");
				movie43.setDirector("Lee Unkrich");
				movie43.setYear(2010);
				movie43.setRating(7);
				movieRepository.save(movie43);
				
				//Alice in Wonderland
				MovieModel movie44 = new MovieModel("Alice in Wonderland");
				movie44.setUrl_movie("https://www.youtube.com/embed/s6hxXMWD_Sg");
				movie44.setDirector("Tim Burton");
				movie44.setYear(2010);
				movie44.setRating(6);
				movieRepository.save(movie44);
				
				//Harry Potter and the Deathly Hallows – Part 1
				MovieModel movie45 = new MovieModel("Harry Potter and the Deathly Hallows – Part 1");
				movie45.setUrl_movie("https://www.youtube.com/embed/MxqsmsA8y5k");
				movie45.setDirector("David Yates");
				movie45.setYear(2010);
				movie45.setRating(6);
				movieRepository.save(movie45);
				
				//Despicable Me
				MovieModel movie46 = new MovieModel("Despicable Me");
				movie46.setUrl_movie("https://www.youtube.com/embed/sUkZFetWYY0");
				movie46.setDirector("Pierre Coffin,  Chris Renaud");
				movie46.setYear(2010);
				movie46.setRating(6);
				movieRepository.save(movie46);
				
				//Harry Potter and the Half-Blood Prince
				MovieModel movie47 = new MovieModel("Harry Potter and the Half-Blood Prince");
				movie47.setUrl_movie("https://www.youtube.com/embed/sg81Lts5kYY");
				movie47.setDirector("David Yates");
				movie47.setYear(2009);
				movie47.setRating(6);
				movieRepository.save(movie47);
				
				//Ice Age: Dawn of the Dinosaurs
				MovieModel movie48 = new MovieModel("Ice Age: Dawn of the Dinosaurs");
				movie48.setUrl_movie("https://www.youtube.com/embed/Y_nSwh2WjAM");
				movie48.setDirector("Carlos Saldanha,  Mike Thurmeier");
				movie48.setYear(2009);
				movie48.setRating(6);
				movieRepository.save(movie48);
				
				//Transformers: Revenge of the Fallen
				MovieModel movie49 = new MovieModel("Transformers: Revenge of the Fallen");
				movie49.setUrl_movie("https://www.youtube.com/embed/uH3STHC63hU");
				movie49.setDirector("Michael Bay");
				movie49.setYear(2009);
				movie49.setRating(5);
				movieRepository.save(movie49);
				
				//2012
				MovieModel movie50 = new MovieModel("2012");
				movie50.setUrl_movie("https://www.youtube.com/embed/y9vGMPUvTew");
				movie50.setDirector("Roland Emmerich");
				movie50.setYear(2009);
				movie50.setRating(4);
				movieRepository.save(movie50);
				
				//Up
				MovieModel movie51 = new MovieModel("Up");
				movie51.setUrl_movie("https://www.youtube.com/embed/qas5lWp7_R0");
				movie51.setDirector("Pete Docter,  Bob Peterson");
				movie51.setYear(2009);
				movie51.setRating(7);
				movieRepository.save(movie51);
				
				//Indiana Jones and the Kingdom of the Crystal Skull
				MovieModel movie52 = new MovieModel("Indiana Jones and the Kingdom of the Crystal Skull");
				movie52.setUrl_movie("https://www.youtube.com/embed/Ibc7Au8SSB0");
				movie52.setDirector("Steven Spielberg");
				movie52.setYear(2008);
				movie52.setRating(5);
				movieRepository.save(movie52);
				
				//Kung Fu Panda
				MovieModel movie53 = new MovieModel("Kung Fu Panda");
				movie53.setUrl_movie("https://www.youtube.com/embed/PXi3Mv6KMzY");
				movie53.setDirector("Mark Osborne,  John Stevenson");
				movie53.setYear(2008);
				movie53.setRating(6);
				movieRepository.save(movie53);
				
				//Hancock
				MovieModel movie54 = new MovieModel("Hancock");
				movie54.setUrl_movie("https://www.youtube.com/embed/rZQQgvhn4jg");
				movie54.setDirector("Peter Berg");
				movie54.setYear(2008);
				movie54.setRating(5);
				movieRepository.save(movie54);
				
				//WALL-E
				MovieModel movie55 = new MovieModel("WALL-E");
				movie55.setUrl_movie("https://www.youtube.com/embed/8-_9n5DtKOc");
				movie55.setDirector("Andrew Stanton");
				movie55.setYear(2008);
				movie55.setRating(7);
				movieRepository.save(movie55);
				
			}// if repository not initialized
		
		}//initDatabase
		
}
