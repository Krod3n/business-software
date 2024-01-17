/**
 * class for User service
 */
package fr.a.factures.security.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.a.factures.security.models.User;
import fr.a.factures.security.repository.UserRepository;

/**
 * @author Stagiaire
 *
 */
@Service
public class UserService implements IUserService {

	/**
	 * call user repository.
	 */
	@Autowired
	private UserRepository userRepo;

	/**
	 * get User by is id.
	 * 
	 * @param id User id
	 * @return User
	 */
	@Override
	public User getUser(final long id) {
		return userRepo.getReferenceById(id);
	}

	@Override
	public Optional<User> findByUsername(final String username) {
		return userRepo.findByUsername(username);
	}
}
