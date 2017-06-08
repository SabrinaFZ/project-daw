create database IF NOT EXISTS iRentMovies;
use iRentMovies;

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `movie` (
  `movie_id` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `director` varchar(255) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `url_cover` varchar(255) DEFAULT NULL,
  `url_movie` varchar(255) NOT NULL,
  `year` int(11) DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `movie_model_cast` (
  `movie_model_movie_id` int(11) NOT NULL,
  `cast` varchar(255) DEFAULT NULL,
  KEY `FKhpcd5mn72ch3mv9blt19guxfn` (`movie_model_movie_id`),
  CONSTRAINT `FKhpcd5mn72ch3mv9blt19guxfn` FOREIGN KEY (`movie_model_movie_id`) REFERENCES `movie` (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `user_model_roles` (
  `user_model_user_id` int(11) NOT NULL,
  `roles` tinyblob,
  KEY `FKqi5o32o7jo6jal3prk3rel2dl` (`user_model_user_id`),
  CONSTRAINT `FKqi5o32o7jo6jal3prk3rel2dl` FOREIGN KEY (`user_model_user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;