/**
 *  interface User repository
 */
package fr.a.factures.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.a.factures.security.models.User;

/**
 * @author Stagiaire
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Method to find username of User.
	 * 
	 * @param username Username of User
	 * @return username
	 */
	Optional<User> findByUsername(String username);

}
