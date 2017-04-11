package org.sabrina.repository;

import org.sabrina.model.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RolModel, Long>{
	RolModel findByRole(String role);

}
