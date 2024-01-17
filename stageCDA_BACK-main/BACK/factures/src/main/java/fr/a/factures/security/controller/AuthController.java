/**
 *  Controller Auth
 */
package fr.a.factures.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.a.factures.helpers.MagicNumber;
import fr.a.factures.security.controller.dto.JwtResponse;
import fr.a.factures.security.controller.dto.LoginRequest;
import fr.a.factures.security.jwt.JwtProvider;

/**
 * @author Stagiaire
 *
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000", maxAge = MagicNumber.ORIGIN)
public class AuthController {

	/**
	 * value of tokenHeader.
	 */
	@Value("${app.jwtTokenHeader}")
	private String tokenHeader;

	/**
	 * call AuthenticationManager.
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * call JwtProvider.
	 */
	@Autowired
	private JwtProvider tokenProvider;

	/**
	 * post for connexion.
	 * @param loginRequest
	 * @return ResponseEntity with new JwtResponse
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody final LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest
						.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JwtResponse(jwt, tokenHeader));
	}

}
