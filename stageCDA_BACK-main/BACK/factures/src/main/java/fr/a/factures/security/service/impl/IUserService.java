/**
 * interface for User service
 */
package fr.a.factures.security.service.impl;

import java.util.Optional;

import fr.a.factures.security.models.User;

/**
 * @author Stagiaire
 *
 */
public interface IUserService {

	/**
	 * for get User by is id.
	 * 
	 * @param id of User
	 * @return User
	 */
	User getUser(long id);

	Optional<User> findByUsername(String userUsernameFromJWT);

}
