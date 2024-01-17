/**
 *  Mapper for User
 */
package fr.a.factures.security.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import fr.a.factures.security.dto.UserDTO;
import fr.a.factures.security.models.User;

/**
 * @author Stagiaire
 *
 */
public class UserMapper {

	/**
	 * User to UserPrincipal.
	 * 
	 * @param user
	 * @return userp UserPrincipal
	 */
	public static UserPrincipal userToPrincipal(final User user) {
		UserPrincipal userp = new UserPrincipal();
		List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

		userp.setUsername(user.getUsername());
		userp.setPassword(user.getPassword());
		userp.setEnabled(true);
		userp.setAuthorities(authorities);
		return userp;
	}

	/**
	 * Transform User entity to UserDTO.
	 * 
	 * @param user User entity
	 * @return dto UserDTO
	 */
	public static UserDTO toDto(final User user) {
		UserDTO dto = null;

		if (user != null) {
			dto = new UserDTO();
			dto.setId(user.getId());
			dto.setUsername(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setLastname(user.getLastname());
			dto.setFirstname(user.getFirstname());
			dto.setEmail(user.getEmail());
			dto.setPicture(user.getPicture());
			dto.setRoles(user.getRoles());

		}
		return dto;
	}

}
