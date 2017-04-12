package org.sabrina.repository;

import org.sabrina.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserModel, Long>{
	UserModel findByUsername(String username);

}
