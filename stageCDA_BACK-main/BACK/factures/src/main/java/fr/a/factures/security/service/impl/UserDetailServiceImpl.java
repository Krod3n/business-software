/**
 * class for User detail service implements
 */
package fr.a.factures.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.a.factures.security.models.User;
import fr.a.factures.security.repository.UserRepository;
import fr.a.factures.security.utils.UserMapper;

/**
 * @author Stagiaire
 *
 */
@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	/**
	 * call UserRepository.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * for load User by is username.
	 */
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User NOT Found"));
		return UserMapper.userToPrincipal(user);

}

}
