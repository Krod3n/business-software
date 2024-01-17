/**
 * Controller for User
 */
package fr.a.factures.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.a.factures.helpers.MagicNumber;
import fr.a.factures.security.dto.UserDTO;
import fr.a.factures.security.jwt.JwtAuthenticationFilter;
import fr.a.factures.security.jwt.JwtProvider;
import fr.a.factures.security.models.User;
import fr.a.factures.security.service.impl.IUserService;
import fr.a.factures.security.utils.UserMapper;

/**
 * @author Stagiaire
 *
 */
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000", maxAge = MagicNumber.ORIGIN)
public class UserController {

	/**
	 * call interface UserService.
	 */
	@Autowired
	private IUserService userService;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private JwtAuthenticationFilter jwtAuthFilter;

	/**
	 * get User.
	 * 
	 * @param id       of User
	 * @param response
	 * @return dto UserDTO
	 */
	@GetMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public UserDTO getUser(@PathVariable("id") final long id, final HttpServletResponse response) {
		UserDTO dto = UserMapper.toDto(userService.getUser(id));

		if (dto == null) {
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
		return dto;
	}

	@GetMapping("/info")
	public UserDTO getUserInfo(HttpServletRequest request) {
		User user = userService
				.findByUsername(jwtProvider.getUserUsernameFromJWT(jwtAuthFilter.getJwtFromRequest(request))).get();
		UserDTO userDTO = UserMapper.toDto(user);
		return userDTO;
	}
}
